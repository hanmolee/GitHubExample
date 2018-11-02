package com.leehanmo.githubexample.injection.module

import com.leehanmo.githubexample.injection.annotation.ActivityScope
import com.leehanmo.githubexample.ui.search.SearchContract
import com.leehanmo.githubexample.ui.search.SearchModule
import com.leehanmo.githubexample.ui.search.SearchPresenter
import dagger.Binds
import dagger.Module

@Module(includes = [SearchModule::class])
abstract class SearchActivityModule {

    @ActivityScope
    @Binds
    abstract fun searchPresenter(searchPresenter: SearchPresenter) : SearchContract.Presenter
}