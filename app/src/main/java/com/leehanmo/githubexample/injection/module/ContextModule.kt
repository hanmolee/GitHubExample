package com.leehanmo.githubexample.injection.module

import android.app.Application
import android.content.Context
import com.leehanmo.githubexample.base.BaseView
import dagger.Module
import dagger.Provides

@Module
object ContextModule {

    @Provides
    internal fun provideContext(baseView: BaseView) : Context {
        return baseView.getContext()
    }

    @Provides
    internal fun provideApplication(context: Context) : Application {
        return context.applicationContext as Application
    }

}