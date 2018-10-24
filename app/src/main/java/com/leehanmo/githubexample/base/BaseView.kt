package com.leehanmo.githubexample.base

import android.content.Context
import android.support.annotation.StringRes

interface BaseView {

    fun getContext() : Context

    fun showError(error : String)

    fun showError(@StringRes errorResId : Int) {
        this.showError(getContext().getString(errorResId))
    }

}