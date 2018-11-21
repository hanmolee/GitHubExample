package com.leehanmo.githubexample.ui.repo

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leehanmo.githubexample.R
import com.leehanmo.githubexample.base.BaseFragment
import com.leehanmo.githubexample.injection.annotation.ActivityScope
import com.leehanmo.githubexample.model.Repo
import com.leehanmo.githubexample.util.USER_NAME
import kotlinx.android.synthetic.main.fragment_repo.*
import javax.inject.Inject
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.toast


@ActivityScope
class RepoFragment @Inject constructor() : BaseFragment(), RepoContract.View {

    @Inject
    lateinit var presenter: RepoPresenter

    private val repoAdapter : RepoAdapter by lazy { RepoAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_repo, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupRepoList()

        repoRefresh?.setOnRefreshListener {
            presenter.loadRepoList()
        }
        presenter.takeView(this)
    }

    private fun setupRepoList() {
        with(repoList) {
            adapter = repoAdapter
            layoutManager = LinearLayoutManager(context)

            val infiniteScrollListener = object : InfiniteScrollListener(layoutManager as LinearLayoutManager) {
                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                    presenter.updateRepoList(page)
                }
            }
            addOnScrollListener(infiniteScrollListener)
        }
    }

    override fun loadRepoList(repoList: MutableList<Repo>) {
        repoAdapter.refreshRepo(repoList)
    }

    override fun updateRepoList(repoList: MutableList<Repo>) {
        repoAdapter.updateRepo(repoList)
    }

    override fun getUserName(): String? {
      return arguments?.getString(USER_NAME)
    }

    override fun showLoading() {
        repoRefresh?.isRefreshing = true
    }

    override fun hideLoading() {
        repoRefresh?.isRefreshing = false
    }

    override fun showError(error: String) {
        context?.toast(error)
    }

    override fun onDestroy() {
        presenter.dropView()
        super.onDestroy()
    }
}