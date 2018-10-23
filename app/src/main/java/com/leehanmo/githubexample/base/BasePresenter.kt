package com.leehanmo.githubexample.base

import com.leehanmo.githubexample.injection.component.DaggerPresenterInjector
import com.leehanmo.githubexample.injection.component.PresenterInjector
import com.leehanmo.githubexample.injection.module.ContextModule
import com.leehanmo.githubexample.injection.module.NetworkModule
import com.leehanmo.githubexample.ui.search.SearchPresenter


abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    private val injector : PresenterInjector = DaggerPresenterInjector.builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated() {}

    open fun onViewDestroyed() {}

    private fun inject() {
        when(this) {
            is SearchPresenter -> injector.inject(this)
        }
    }
}