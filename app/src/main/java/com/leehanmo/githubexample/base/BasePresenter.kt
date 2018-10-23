package com.leehanmo.githubexample.base

import android.view.View

abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    init {
        inject()
    }

    open fun onViewCreated() {}

    open fun onViewDestroyed() {}

    private fun inject() {

    }
}