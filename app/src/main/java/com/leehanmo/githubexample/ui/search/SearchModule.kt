package com.leehanmo.githubexample.ui.search

import com.leehanmo.githubexample.injection.annotation.ActivityScope
import com.leehanmo.githubexample.network.SearchApi
import com.leehanmo.githubexample.network.repository.SearchRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module
class SearchModule {

    @Provides
    @ActivityScope
    fun provideSearchRestApi(@Named("retrofit") retrofit: Retrofit) : SearchApi {
        return retrofit.create(SearchApi::class.java)
    }

    @Provides
    @ActivityScope
    fun provideSearchRepository(searchApi: SearchApi) : SearchRepository {
        return SearchRepository(searchApi)
    }

}