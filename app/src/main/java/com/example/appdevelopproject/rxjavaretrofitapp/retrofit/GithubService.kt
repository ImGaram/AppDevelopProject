package com.example.appdevelopproject.rxjavaretrofitapp.retrofit

import com.example.appdevelopproject.rxjavaretrofitapp.data.GithubUserInfo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{owner}")
    fun getUsers(@Path("owner") owner: String): Single<GithubUserInfo>
}