package com.leehanmo.githubexample.ui.repo

import com.leehanmo.githubexample.base.BaseView
import com.leehanmo.githubexample.model.Repo

interface RepoView : BaseView {

    fun updateRepo(repo : List<Repo>)

    fun showRefreshing()

    fun hideRefreshing()

    fun getUserName() : String
}