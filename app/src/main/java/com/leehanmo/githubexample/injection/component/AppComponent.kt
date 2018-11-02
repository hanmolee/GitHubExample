package com.leehanmo.githubexample.injection.component

import android.content.Context
import com.leehanmo.githubexample.App
import com.leehanmo.githubexample.injection.module.ActivityBindModule
import com.leehanmo.githubexample.injection.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class,
        ActivityBindModule::class, NetworkModule::class))
interface AppComponent : AndroidInjector<App> {

    override fun inject(instance: App?)

    @Component.Builder
    interface Builder {
        fun build() : AppComponent

        @BindsInstance
        fun application(applicationContext: Context) : Builder
    }

}