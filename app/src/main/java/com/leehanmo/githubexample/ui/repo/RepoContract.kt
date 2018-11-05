package com.leehanmo.githubexample.ui.repo

import com.leehanmo.githubexample.base.BasePresenter
import com.leehanmo.githubexample.base.BaseView

interface RepoContract {

    interface View : BaseView {

    }

    interface Presenter : BasePresenter<View> {

    }
}