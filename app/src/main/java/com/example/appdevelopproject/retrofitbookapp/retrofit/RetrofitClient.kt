package com.example.appdevelopproject.retrofitbookapp.retrofit

import android.util.Log
import com.example.appdevelopproject.retrofitbookapp.Constants.TAG
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // 레트로핏 클라이언트 선언
    private var retrofitClient: Retrofit? = null

    // 클라이언트 가져오기
    fun getClient(baseurl: String): Retrofit? {
        Log.d(TAG,"RetrofitClient - getClient() called")

        // 기본적인 retrofit 빌드
        if (retrofitClient == null) {
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofitClient
    }
}