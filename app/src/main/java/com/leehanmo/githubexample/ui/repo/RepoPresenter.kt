package com.leehanmo.githubexample.ui.repo

import com.leehanmo.githubexample.injection.annotation.ActivityScope
import com.leehanmo.githubexample.network.repository.RepoRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@ActivityScope
class RepoPresenter @Inject constructor(private val repoRepository: RepoRepository) : RepoContract.Presenter {

    private var repoView : RepoContract.View? = null
    val compositeDisposable : CompositeDisposable by lazy { CompositeDisposable() }

    override fun takeView(view: RepoContract.View) {
        repoView = view
        repoView?.showLoading()
        loadRepoList()
    }


    override fun loadRepoList() {
        repoView?.getUserName()?.run {
            repoRepository.getRepoList(this)
                    .doOnSuccess { repoView?.hideLoading() }
                    .doOnError { repoView?.hideLoading() }
                    .subscribe(
                            { repoList ->
                                repoList?.run { repoView?.updateRepoList(this) }
                            },
                            {}
                    ).apply { compositeDisposable.add(this) }
        }
    }

    override fun dropView() {
        compositeDisposable.clear()
        repoView = null
    }

}