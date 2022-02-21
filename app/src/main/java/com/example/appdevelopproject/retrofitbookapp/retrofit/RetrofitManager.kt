package com.example.appdevelopproject.retrofitbookapp.retrofit

import android.util.Log
import com.example.appdevelopproject.retrofitbookapp.API
import com.example.appdevelopproject.retrofitbookapp.Constants.TAG
import com.example.appdevelopproject.retrofitbookapp.RESPONSE_STATE
import com.example.appdevelopproject.retrofitbookapp.data.MainBooksData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager {

    companion object {
        val instance = RetrofitManager()    // instance로 retrofitManager 가져올수 잇음
    }

    fun searchBooks(completion: (RESPONSE_STATE, String) -> Unit) {
        var retrofitInterface: RetrofitInterface?
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(API.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitInterface = retrofit.create(RetrofitInterface::class.java)
        retrofitInterface.searchBooks(API.API_KEY).enqueue(object :Callback<MainBooksData> {
            override fun onResponse(call: Call<MainBooksData>, response: Response<MainBooksData>) {
                Log.d(TAG, "onResponse: api 호출 성공 / response : ${response.raw()}")
                if (response.isSuccessful.not()) {
                    return
                }
                completion(RESPONSE_STATE.OKAY, response.raw().toString())
            }

            override fun onFailure(call: Call<MainBooksData>, t: Throwable) {
                Log.d(TAG, "onResponse: api 호출 실패 / throwable : $t")
                completion(RESPONSE_STATE.FAIL, t.toString())
            }

        })
    }

}