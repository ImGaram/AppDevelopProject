package com.example.appdevelopproject.retrofitbookapp.retrofit

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    // https://book.interpark.com/api/bestSeller.api?key=apikey&categoryId=100&output=json

    @GET("/api/bestSeller.api?categoryId=100&output=json")
    fun searchBooks(@Query("key") apiKey:String):Call<JsonElement>
}