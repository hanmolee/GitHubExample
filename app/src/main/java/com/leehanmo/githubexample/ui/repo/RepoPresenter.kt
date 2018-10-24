package com.leehanmo.githubexample.ui.repo

import android.util.Log
import com.leehanmo.githubexample.R
import com.leehanmo.githubexample.base.BasePresenter
import com.leehanmo.githubexample.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepoPresenter(repoView: RepoView) : BasePresenter<RepoView>(repoView) {

    @Inject
    lateinit var apiService: ApiService

    val compositeDisposable : CompositeDisposable by lazy { CompositeDisposable() }

    override fun onViewCreated() {
        super.onViewCreated()
        view.showRefreshing()
        loadRepo()
    }

    fun loadRepo() {
        apiService.getRepo(view.getUserName())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { repoList ->
                            Log.e("haha", repoList.toString())
                            repoList?.run { view.updateRepo(repoList) }
                                    ?: kotlin.run {  }
                            view.hideRefreshing()
                        }, { view.showError(R.string.error) }
                )
                .apply { compositeDisposable.add(this) }
    }

    override fun onViewDestroyed() {
        compositeDisposable.clear()
        super.onViewDestroyed()
    }
}