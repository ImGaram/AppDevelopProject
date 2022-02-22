package com.example.appdevelopproject.retrofitbookapp.retrofit

import android.util.Log
import com.example.appdevelopproject.retrofitbookapp.API
import com.example.appdevelopproject.retrofitbookapp.Constants.TAG
import com.example.appdevelopproject.retrofitbookapp.RESPONSE_STATE
import com.example.appdevelopproject.retrofitbookapp.data.Book
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RetrofitManager {

    companion object {
        val instance = RetrofitManager()    // instance로 retrofitManager 가져올수 잇음
    }

    fun searchBooks(completion: (RESPONSE_STATE, ArrayList<Book>?) -> Unit) {
        var retrofitInterface: RetrofitInterface?
        val retrofit: Retrofit? = RetrofitClient.getClient(API.BASE_URL)

        retrofitInterface = retrofit?.create(RetrofitInterface::class.java)
        retrofitInterface?.searchBooks(API.API_KEY)?.enqueue(object :Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "onResponse: api 호출 성공 / response : ${response.body()}")
                if (response.isSuccessful.not()) {
                    return
                }
                response.body().let {
                    val bookList = ArrayList<Book>()
                    val body = it?.asJsonObject
                    val results = body?.getAsJsonArray("item")

                    results?.forEach { resultItem ->
                        val bookItemObject = resultItem.asJsonObject

                        val title = bookItemObject.get("title").asString
                        val publisher = bookItemObject.get("publisher").asString
                        val author = bookItemObject.get("author").asString
                        val coverLargeUrl = bookItemObject.get("coverLargeUrl").asString
                        val mobileLink = bookItemObject.get("mobileLink").asString
                        val customerReviewRank = bookItemObject.get("customerReviewRank").asFloat
                        val rank = bookItemObject.get("rank").asString

                        val book = Book(
                            title, publisher, author, coverLargeUrl, mobileLink, customerReviewRank, rank
                        )
                        bookList.add(book)
                    }
                    completion(RESPONSE_STATE.OKAY, bookList)
                }
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "onResponse: api 호출 실패 / throwable : $t")
                completion(RESPONSE_STATE.FAIL, null)
            }

        })
    }

}