package com.leehanmo.githubexample.ui.repo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.leehanmo.githubexample.R
import com.leehanmo.githubexample.base.BaseActivity
import dagger.Lazy
import javax.inject.Inject

class RepoActivity @Inject constructor() : BaseActivity(), RepoContract.View {

    @Inject
    lateinit var repoFragmentProvider: Lazy<RepoFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)
    }

    

    override fun getContext(): Context {
        return this@RepoActivity
    }
}