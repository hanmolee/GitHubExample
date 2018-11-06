package com.leehanmo.githubexample.injection.module

import com.leehanmo.githubexample.injection.annotation.ActivityScope
import com.leehanmo.githubexample.injection.annotation.FragmentScope
import com.leehanmo.githubexample.ui.repo.RepoContract
import com.leehanmo.githubexample.ui.repo.RepoFragment
import com.leehanmo.githubexample.ui.repo.RepoModule
import com.leehanmo.githubexample.ui.repo.RepoPresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [RepoModule::class])
abstract class RepoActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun repoFragment(): RepoFragment

    @ActivityScope
    @Binds
    abstract fun repoPresenter(presenter: RepoPresenter): RepoContract.Presenter

}