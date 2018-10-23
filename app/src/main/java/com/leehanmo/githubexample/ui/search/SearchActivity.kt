package com.leehanmo.githubexample.ui.search

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding2.view.clicks
import com.leehanmo.githubexample.R
import com.leehanmo.githubexample.base.BaseActivity
import com.leehanmo.githubexample.databinding.ActivitySearchBinding
import com.leehanmo.githubexample.model.UserInfo
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.toast
import java.util.concurrent.TimeUnit

class SearchActivity : BaseActivity<SearchPresenter>(), SearchView {

    private lateinit var binding : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        presenter.onViewCreated()

        searchButton.clicks()
                .throttleFirst(500, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .filter { inputUserName.text.isNotEmpty() }
                .subscribe {
                    presenter.searchUserInfo(inputUserName.text.toString())
                }
                .apply { presenter.compositeDisposable.add(this) }
    }

    override fun onDestroy() {
        presenter.onViewDestroyed()
        super.onDestroy()
    }

    override fun instantiatePresenter(): SearchPresenter {
        return SearchPresenter(this)
    }

    override fun showUserInfo(userInfo: UserInfo) {
        binding.notResultVisibility = View.GONE
        binding.userInfoVisibility = View.VISIBLE

        Glide.with(getContext()).load(userInfo.avatar_url).into(profileImg)
        binding.userInfo = userInfo
        binding.executePendingBindings()
    }

    override fun showError(error: String) {
        toast(error)
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun showNotResult() {
        binding.notResultVisibility = View.VISIBLE
        binding.userInfoVisibility = View.GONE
    }

}