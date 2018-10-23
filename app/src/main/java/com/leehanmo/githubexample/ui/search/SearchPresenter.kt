package com.leehanmo.githubexample.ui.search

import android.util.Log
import com.leehanmo.githubexample.R
import com.leehanmo.githubexample.base.BasePresenter
import com.leehanmo.githubexample.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchPresenter(searchView: SearchView) : BasePresenter<SearchView>(searchView) {

    @Inject
    lateinit var apiService: ApiService

    val compositeDisposable : CompositeDisposable by lazy { CompositeDisposable() }

    override fun onViewCreated() {
        super.onViewCreated()
        view.hideLoading()
    }

    fun searchUserInfo(userName : String) {
        view.showLoading()
        apiService.getUserInfo(userName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { userInfo ->
                            Log.e("hahaha", userInfo.toString())
                            userInfo?.run { view.showUserInfo(userInfo) }
                                    ?: kotlin.run { view.showNotResult() }
                        }, { view.showError(R.string.error) }
                )
                .apply { compositeDisposable.add(this) }

    }

    override fun onViewDestroyed() {
        compositeDisposable.clear()
    }
}