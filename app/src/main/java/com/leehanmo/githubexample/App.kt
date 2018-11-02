package com.leehanmo.githubexample

import com.leehanmo.githubexample.injection.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val applicationComponent =
                DaggerAppComponent
                        .builder()
                        .application(this)
                        .build()

        applicationComponent.inject(this)

        return applicationComponent
    }

}