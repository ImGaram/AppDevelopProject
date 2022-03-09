package com.example.appdevelopproject.rxjavaretrofitapp.data

import com.google.gson.annotations.SerializedName

data class GithubUserInfo(
    @SerializedName("login") var login: String,
    @SerializedName("avatar_url") var avatarUrl: String,
    @SerializedName("html_url") var htmlUrl: String,
    @SerializedName("name") var name: String,
    @SerializedName("followers") var followers: String,
    @SerializedName("following") var following: String
)
