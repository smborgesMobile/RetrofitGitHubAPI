package com.example.myapplication.rest

import com.example.myapplication.model.GitHubRepository
import com.example.myapplication.model.GitHubUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubUserEndPoints {
    //Method we are going to use // EndPoint
    @GET("/users/{user}")
    fun getUser(@Path("user") user: String): Call<GitHubUser>

    @GET("/users/{user}/repos")
    fun getRepos(@Path("user") user: String): Call<List<GitHubRepository>>

}