package com.example.myapplication.acitivty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.RepoAdapter
import com.example.myapplication.model.GitHubRepository
import com.example.myapplication.rest.APIClient
import com.example.myapplication.rest.GitHubUserEndPoints
import kotlinx.android.synthetic.main.activity_repositories.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoriesActivity : AppCompatActivity() {

    val repoList = ArrayList<GitHubRepository>()
    var repoAdapter: RepoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories)

        val userName = intent.getStringExtra("USER_NAME")
        textView_repos_username?.text = "Username: $userName"

        val recyclerView = recyclerview_repos
        repoAdapter = RepoAdapter(repoList, this)
        recyclerView.adapter = repoAdapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        loadRepos(userName)
    }


    private fun loadRepos(userName: String) {
        val apiService: GitHubUserEndPoints =
            APIClient().initRetrofit().create(GitHubUserEndPoints::class.java)

        val call = apiService.getRepos(userName)

        call.enqueue(object : Callback<List<GitHubRepository>> {
            override fun onResponse(
                call: Call<List<GitHubRepository>>,
                response: Response<List<GitHubRepository>>
            ) {
                repoList.clear()
                response.body()?.let { repoList.addAll(it) }
                repoAdapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<GitHubRepository>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}
