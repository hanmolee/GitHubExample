package com.leehanmo.githubexample.base

import android.content.Context

interface BaseView {

    fun showLoading()
    fun hideLoading()
    fun showError(error : String)
}