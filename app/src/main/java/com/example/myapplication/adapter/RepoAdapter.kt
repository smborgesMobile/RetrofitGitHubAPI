package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.GitHubRepository
import kotlinx.android.synthetic.main.layout_recycler_view.view.*

class RepoAdapter(private val repos: ArrayList<GitHubRepository>, private var context: Context) :
    RecyclerView.Adapter<RepoAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = repos[position]
        holder.repoName.text = "Name: ${repo.repoName}"
        holder.repoDescription.text = "Description:  ${repo.repoDescription}"
        holder.repoLanguage.text = "Language: ${repo.repoLanguage}"

    }

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_recycler_view, null)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repoName = itemView.textView_repo_name
        val repoDescription = itemView.textView_repo_description
        val repoLanguage = itemView.textView_repo_language
    }
}

