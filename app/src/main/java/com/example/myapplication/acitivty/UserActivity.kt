package com.example.myapplication.acitivty

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.GitHubUser
import com.example.myapplication.rest.APIClient
import com.example.myapplication.rest.GitHubUserEndPoints
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val user_name = intent.getStringExtra("USER_NAME")
        loadData(user_name)
    }

    fun loadData(userName: String) {
        val apiService: GitHubUserEndPoints =
            APIClient().initRetrofit().create(GitHubUserEndPoints::class.java)

        val call = apiService.getUser(userName)
        call.enqueue(object : Callback<GitHubUser?> {
            override fun onResponse(call: Call<GitHubUser?>, response: Response<GitHubUser?>) {
                textView_userName.text = "Username: ${response.body()?.name}"
                textView_userFollowers.text = "Followers: ${response.body()?.followers}"
                textView_userFollowing.text = "Following: ${response.body()?.following}"
                textView_userLogin.text = "Company: ${response.body()?.company}"
                textView_userEmail.text = "Login: ${response.body()?.login}"

                var imageUrl = response.body()?.avatar

                Glide.with(applicationContext)
                    .load(imageUrl)
                    .into(imageView_avatar)
            }

            override fun onFailure(call: Call<GitHubUser?>, t: Throwable) {
                Log.d("sm.borges", "Fail to query data into API: $t")
            }
        })
    }
}
