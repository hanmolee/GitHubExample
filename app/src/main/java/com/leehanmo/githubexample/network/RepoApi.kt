package com.leehanmo.githubexample.network

import com.leehanmo.githubexample.model.Repo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepoApi {

    @GET("/users/{userName}/repos")
    fun getRepo(@Path("userName") userName: String, @Query("page") page : Int, @Query("per_page") perPage : Int): Single<MutableList<Repo>>
}