package com.leehanmo.githubexample.base

import com.leehanmo.githubexample.injection.component.DaggerRepoComponent
import com.leehanmo.githubexample.injection.component.DaggerSearchComponent
import com.leehanmo.githubexample.injection.module.ContextModule
import com.leehanmo.githubexample.injection.module.NetworkModule
import com.leehanmo.githubexample.ui.repo.RepoPresenter
import com.leehanmo.githubexample.ui.search.SearchPresenter


abstract class BasePresenter<out V : BaseView>(protected val view: V) {


    init {
        inject()
    }

    open fun onViewCreated() {}

    open fun onViewDestroyed() {}

    private fun inject() {
        when(this) {
            is SearchPresenter -> {
                DaggerSearchComponent.builder()
                        .baseView(view)
                        .contextModule(ContextModule)
                        .networkModule(NetworkModule)
                        .build()
                        .inject(this)

                
            }

            is RepoPresenter -> {
                DaggerRepoComponent.builder()
                        .baseView(view)
                        .contextModule(ContextModule)
                        .networkModule(NetworkModule)
                        .build()
                        .inject(this)
            }
        }

    }
}