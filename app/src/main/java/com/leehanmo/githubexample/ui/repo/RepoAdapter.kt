package com.leehanmo.githubexample.ui.repo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leehanmo.githubexample.R
import com.leehanmo.githubexample.model.Repo
import kotlinx.android.synthetic.main.item_repo.view.*

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    private var repoList : List<Repo> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    fun updateRepo(repoList : List<Repo>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }

    inner class RepoViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {

        fun onBind(repo: Repo) {
            view.run {
                repoNameText.text = repo.name
                repoDescriptionText.text = repo.description
                repoStarText.text = repo.stargazers_count.toString()
            }
        }
    }
}