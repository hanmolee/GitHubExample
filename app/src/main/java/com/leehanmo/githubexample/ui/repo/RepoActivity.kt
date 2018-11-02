package com.leehanmo.githubexample.ui.repo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.leehanmo.githubexample.R
import com.leehanmo.githubexample.base.BaseActivity
import com.leehanmo.githubexample.model.Repo
import kotlinx.android.synthetic.main.activity_repo.*
import org.jetbrains.anko.toast

class RepoActivity : BaseActivity<RepoPresenter>(), RepoView {


    private val repoAdapter = RepoAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)

        with(repoList) {
            adapter = repoAdapter
        }

        refreshLayout.setOnRefreshListener {
            presenter.loadRepo()
        }

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        presenter.onViewDestroyed()
        super.onDestroy()
    }

    override fun showRefreshing() {
        refreshLayout.isRefreshing = true
    }

    override fun hideRefreshing() {
        refreshLayout.isRefreshing = false
    }

    override fun instantiatePresenter(): RepoPresenter {
        return RepoPresenter(this)
    }

    override fun showError(error: String) {
        toast(error)
    }

    override fun updateRepo(repo: List<Repo>) {
        repoAdapter.updateRepo(repo)
    }

    override fun getUserName(): String {
        return intent.getStringExtra("userName")
    }

    companion object {
        fun newIntent(context: Context, userName : String) : Intent {

            val repoIntent = Intent(context, RepoActivity::class.java)
            repoIntent.putExtra("userName", userName)

            return repoIntent
        }
    }

}