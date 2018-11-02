package com.leehanmo.githubexample.ui.search

import com.leehanmo.githubexample.base.BasePresenter
import com.leehanmo.githubexample.base.BaseView
import com.leehanmo.githubexample.model.UserInfo

interface SearchContract {


    interface View : BaseView {
        fun showUserInfo(userInfo: UserInfo)

        fun showLoading()

        fun hideLoading()

        fun showNotResult()

        fun startNextActivity(userName : String)
    }

    interface Presenter : BasePresenter<View> {
        fun searchUserInfo(userName: String)
        fun saveUserName(userName: String)
        fun getUserName() : String?
    }

}