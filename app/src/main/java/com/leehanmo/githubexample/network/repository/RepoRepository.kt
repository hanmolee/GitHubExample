package com.leehanmo.githubexample.network.repository

import com.leehanmo.githubexample.model.Repo
import com.leehanmo.githubexample.network.RepoApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepoRepository(private val repoApi: RepoApi) {

    fun getRepoList(userName : String) : Single<List<Repo>> {
        return repoApi.getRepo(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}