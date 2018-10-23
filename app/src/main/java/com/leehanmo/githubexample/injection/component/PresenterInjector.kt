package com.leehanmo.githubexample.injection.component

import com.leehanmo.githubexample.base.BasePresenter
import com.leehanmo.githubexample.base.BaseView
import com.leehanmo.githubexample.injection.module.ContextModule
import com.leehanmo.githubexample.injection.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ContextModule::class, NetworkModule::class))
interface PresenterInjector {

    fun <T : BasePresenter<BaseView>> inject(presenter: T)

    @Component.Builder
    interface Builder {

        fun build() : PresenterInjector

        fun networkModule(networkModule : NetworkModule) : Builder
        fun contextModule(contextModule : ContextModule) : Builder

        @BindsInstance
        fun baseView(baseView: BaseView) : Builder
    }
}