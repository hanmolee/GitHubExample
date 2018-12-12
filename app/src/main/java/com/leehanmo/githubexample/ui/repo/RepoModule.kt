package com.leehanmo.githubexample.ui.repo

import com.leehanmo.githubexample.injection.annotation.ActivityScope
import com.leehanmo.githubexample.network.RepoApi
import com.leehanmo.githubexample.network.repository.RepoRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module
class RepoModule {

    @Provides
    @ActivityScope
    fun provideSearchRestApi(@Named("retrofit") retrofit: Retrofit) : RepoApi {
        return retrofit.create(RepoApi::class.java)
    }

    @Provides
    @ActivityScope
    fun provideSearchRepository(repoAcpi: RepoApi) : RepoRepository {
        return RepoRepository(repoAcpi)
    }

}