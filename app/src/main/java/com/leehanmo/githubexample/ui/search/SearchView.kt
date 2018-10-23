package com.leehanmo.githubexample.ui.search

import android.support.annotation.StringRes
import com.leehanmo.githubexample.base.BaseView
import com.leehanmo.githubexample.model.UserInfo

interface SearchView : BaseView {

    fun seachUserInfo(userInfo: UserInfo)

    fun showError(error:String)

    fun showError(@StringRes errorResId : Int)

    fun showLoading()

    fun hideLoading()

    fun showNotResult()

}