package com.leehanmo.githubexample.injection.module

import com.leehanmo.githubexample.injection.annotation.ActivityScope
import com.leehanmo.githubexample.ui.search.SearchActivity
import com.leehanmo.githubexample.ui.search.SearchModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [SearchActivityModule::class])
    abstract fun searchActivity() : SearchActivity

}