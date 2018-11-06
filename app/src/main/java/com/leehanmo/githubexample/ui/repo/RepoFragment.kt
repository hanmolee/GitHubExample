package com.leehanmo.githubexample.ui.repo

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leehanmo.githubexample.R
import com.leehanmo.githubexample.injection.annotation.ActivityScope
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject



@ActivityScope
class RepoFragment @Inject constructor() : Fragment(), RepoContract.View {

    @Inject
    lateinit var presenter: RepoPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_repo, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.takeView(this)
    }

    override fun onDestroy() {
        presenter.dropView()
        super.onDestroy()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

}