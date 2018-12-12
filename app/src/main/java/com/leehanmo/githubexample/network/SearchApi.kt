package com.leehanmo.githubexample.network

import com.leehanmo.githubexample.model.UserInfo
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchApi {

    @GET("/users/{username}")
    fun getUserInfo(@Path("username") userName: String): Single<UserInfo>

}