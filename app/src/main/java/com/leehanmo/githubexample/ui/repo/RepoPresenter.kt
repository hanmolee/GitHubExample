package com.leehanmo.githubexample.ui.repo

import com.leehanmo.githubexample.injection.annotation.ActivityScope
import javax.inject.Inject

@ActivityScope
class RepoPresenter @Inject constructor() : RepoContract.Presenter {

    private var repoView : RepoContract.View? = null

    override fun takeView(view: RepoContract.View) {
        repoView = view
    }

    override fun dropView() {
        repoView = null
    }


}