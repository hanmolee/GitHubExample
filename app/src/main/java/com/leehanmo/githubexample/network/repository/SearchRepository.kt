package com.leehanmo.githubexample.network.repository

import com.leehanmo.githubexample.model.UserInfo
import com.leehanmo.githubexample.network.SearchApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchRepository(private val searchApi: SearchApi) {

    fun getUserInfo(userName : String) : Single<UserInfo> {
        return searchApi.getUserInfo(userName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }
}