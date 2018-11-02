package com.leehanmo.githubexample.network

import com.leehanmo.githubexample.model.Repo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoApi {

    @GET("/users/{username}/repos")
    fun getRepo(@Path("username") userName: String): Single<List<Repo>>

}