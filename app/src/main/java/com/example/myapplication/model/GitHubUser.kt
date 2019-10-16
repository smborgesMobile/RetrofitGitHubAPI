package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class GitHubUser(
    @SerializedName("login")
    var login: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("followers")
    var followers: String,
    @SerializedName("following")
    var following: String,
    @SerializedName("avatar_url")
    var avatar: String,
    @SerializedName("company")
    var company: String
)