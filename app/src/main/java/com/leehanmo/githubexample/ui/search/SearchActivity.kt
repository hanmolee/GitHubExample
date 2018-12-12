package com.leehanmo.githubexample.ui.search

import android.content.Context
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding2.view.clicks
import com.leehanmo.githubexample.R
import com.leehanmo.githubexample.base.BaseActivity
import com.leehanmo.githubexample.injection.annotation.ActivityScope
import com.leehanmo.githubexample.model.UserInfo
import com.leehanmo.githubexample.ui.repo.RepoActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.toast
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@ActivityScope
class SearchActivity : BaseActivity(), SearchContract.View {

    @Inject
    lateinit var presenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        presenter.takeView(this)

        searchButton.clicks()
                .throttleFirst(500, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .filter { inputUserName.text.isNotEmpty() }
                .subscribe {
                    presenter.searchUserInfo(inputUserName.text.toString())
                }.apply { presenter.compositeDisposable.add(this) }

        userInfoForm.clicks()
                .throttleFirst(500, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .filter { userInfoForm.visibility == View.VISIBLE }
                .subscribe {
                    presenter.getUserName()?.run {
                        startNextActivity(this)
                    }
                }.apply { presenter.compositeDisposable.add(this) }


    }

    override fun onDestroy() {
        presenter.dropView()
        super.onDestroy()
    }


    override fun showUserInfo(userInfo: UserInfo) {
        notResultText.visibility = View.GONE
        userInfoForm.visibility = View.VISIBLE

        presenter.saveUserName(userInfo.login)

        Glide.with(getContext()).load(userInfo.avatar_url).into(profileImg)
        userNameText.text = userInfo.name
        userBlogText.text = userInfo.blog
    }

    override fun startNextActivity(userName: String) {
        val nextActivity = RepoActivity.newIntent(this, userName)
        startActivity(nextActivity)
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showNotResult() {
        notResultText.visibility = View.VISIBLE
        userInfoForm.visibility = View.GONE
    }

    override fun showError(error: String) {
        toast(error)
    }

    override fun getContext(): Context {
        return this@SearchActivity
    }
}