package com.leehanmo.githubexample.injection.component

import com.leehanmo.githubexample.base.BaseView
import com.leehanmo.githubexample.injection.module.ContextModule
import com.leehanmo.githubexample.injection.module.NetworkModule
import com.leehanmo.githubexample.ui.repo.RepoPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, NetworkModule::class])
interface RepoComponent {

    fun inject(presenter: RepoPresenter)

    @Component.Builder
    interface Builder {

        fun build() : RepoComponent
        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView) : Builder
    }
}