package com.leehanmo.githubexample.ui.repo

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leehanmo.githubexample.R
import com.leehanmo.githubexample.model.Repo
import kotlinx.android.synthetic.main.item_repo.view.*

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    private var repoList : MutableList<Repo> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.e("hanmolee size", "${repoList.size}")
        return repoList.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    fun updateRepo(repoList : MutableList<Repo>) {
        this.repoList.addAll(repoList)
        notifyDataSetChanged()
    }

    fun refreshRepo(repoList : MutableList<Repo>) {
        this.repoList.clear()
        this.repoList.addAll(repoList)
        notifyDataSetChanged()
    }

    inner class RepoViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {

        fun onBind(repo: Repo) {
            view.run {
                repoName.text = repo.name
                repoDescription.text = repo.description
                repoStarText.text = repo.stargazers_count.toString()
                repoLanguage.text = repo.language
            }
        }
    }
}