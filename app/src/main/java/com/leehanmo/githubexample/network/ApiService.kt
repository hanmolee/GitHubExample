package com.leehanmo.githubexample.network

import com.leehanmo.githubexample.model.Repo
import com.leehanmo.githubexample.model.UserInfo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/users/{username}")
    fun getUserInfo(@Path("username") userName: String): Observable<UserInfo>

    @GET("/users/{username}/repos")
    fun getRepo(@Path("username") userName: String): Observable<List<Repo>>

}