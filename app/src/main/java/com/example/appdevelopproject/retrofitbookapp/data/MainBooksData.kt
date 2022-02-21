package com.example.appdevelopproject.retrofitbookapp.data

import com.google.gson.annotations.SerializedName

data class MainBooksData(
    @SerializedName("title") val title: String,
    @SerializedName("item") val item: List<Book>
)