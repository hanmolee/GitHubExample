package com.leehanmo.githubexample.ui.search

import com.leehanmo.githubexample.base.BaseView
import com.leehanmo.githubexample.model.UserInfo

interface SearchView : BaseView {

    fun showUserInfo(userInfo: UserInfo)

    fun showLoading()

    fun hideLoading()

    fun showNotResult()

    fun startNextActivity(userName : String)
}