package com.leehanmo.githubexample.injection.component

import com.leehanmo.githubexample.base.BaseView
import com.leehanmo.githubexample.injection.module.ContextModule
import com.leehanmo.githubexample.injection.module.NetworkModule
import com.leehanmo.githubexample.ui.search.SearchPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, NetworkModule::class])
interface PresenterInjector {

    fun inject(presenter: SearchPresenter)

    @Component.Builder
    interface Builder {

        fun build() : PresenterInjector

        fun networkModule(networkModule : NetworkModule) : Builder
        fun contextModule(contextModule : ContextModule) : Builder

        @BindsInstance
        fun baseView(baseView: BaseView) : Builder
    }
}