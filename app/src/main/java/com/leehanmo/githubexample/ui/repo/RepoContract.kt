package com.leehanmo.githubexample.ui.repo

import com.leehanmo.githubexample.base.BasePresenter
import com.leehanmo.githubexample.base.BaseView
import com.leehanmo.githubexample.model.Repo

interface RepoContract {

    interface View : BaseView {
        fun updateRepoList(repoList: MutableList<Repo>)
        fun getUserName() : String?
        fun loadRepoList(repoList: MutableList<Repo>)
    }

    interface Presenter : BasePresenter<View> {
        fun loadRepoList()
        fun updateRepoList(page: Int)
    }
}