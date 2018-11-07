package com.leehanmo.githubexample.ui.repo

import com.leehanmo.githubexample.base.BasePresenter
import com.leehanmo.githubexample.base.BaseView
import com.leehanmo.githubexample.model.Repo

interface RepoContract {

    interface View : BaseView {
        fun updateRepoList(repoList: List<Repo>)
        fun getUserName() : String?
    }

    interface Presenter : BasePresenter<View> {
        fun loadRepoList()
    }
}