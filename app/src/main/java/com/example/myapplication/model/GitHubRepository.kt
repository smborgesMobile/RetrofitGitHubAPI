package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class GitHubRepository(
    @SerializedName("name")
    var repoName: String,
    @SerializedName("description")
    var repoDescription: String,
    @SerializedName("language")
    var repoLanguage: String
)