package com.leehanmo.githubexample.ui.search

import com.leehanmo.githubexample.injection.annotation.ActivityScope
import com.leehanmo.githubexample.network.repository.SearchRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@ActivityScope
class SearchPresenter @Inject constructor(private val searchRepository: SearchRepository) : SearchContract.Presenter {

    val compositeDisposable : CompositeDisposable by lazy { CompositeDisposable() }

    private var searchView : SearchContract.View? = null

    private var userName : String? = null

    override fun takeView(view: SearchContract.View) {
        searchView = view
    }


    override fun searchUserInfo(userName: String) {
        searchView?.showLoading()
        searchRepository.getUserInfo(userName)
                .doOnError { searchView?.hideLoading() }
                .doOnSuccess { searchView?.hideLoading() }
                .subscribe(
                        {data -> searchView?.showUserInfo(data)},
                        {  }
                ).apply { compositeDisposable.add(this) }
    }

    override fun saveUserName(userName: String) {
        this.userName = userName
    }

    override fun getUserName() : String? {
        return userName
    }

    override fun dropView() {
        compositeDisposable.clear()
        searchView = null
    }

}