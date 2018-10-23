package com.leehanmo.githubexample.ui.search

import android.support.annotation.StringRes
import com.leehanmo.githubexample.base.BaseView
import com.leehanmo.githubexample.model.UserInfo

interface SearchView : BaseView {

    fun showUserInfo(userInfo: UserInfo)

    fun showError(error:String)

    fun showError(@StringRes errorResId : Int) {
        showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()

    fun showNotResult()

}