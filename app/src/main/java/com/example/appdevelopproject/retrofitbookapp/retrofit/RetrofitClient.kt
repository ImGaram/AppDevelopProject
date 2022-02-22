package com.example.appdevelopproject.retrofitbookapp.retrofit

import android.util.Log
import com.example.appdevelopproject.retrofitbookapp.Constants.TAG
import com.example.appdevelopproject.retrofitbookapp.isJsonArray
import com.example.appdevelopproject.retrofitbookapp.isJsonObject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    // 레트로핏 클라이언트 선언
    private var retrofitClient: Retrofit? = null

    // 클라이언트 가져오기
    fun getClient(baseurl: String): Retrofit? {
        Log.d(TAG,"RetrofitClient - getClient() called")

        // okhttp 인스턴스
        val client = OkHttpClient.Builder()

        // 로그를 찍기 위한 로깅 인터셉터
        val loggingInterceptor = HttpLoggingInterceptor(object :HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d(TAG, "log - called / message: $message")

                when {
                    message.isJsonObject() ->
                        Log.d(TAG, JSONObject(message).toString(4))
                    message.isJsonArray() ->
                        Log.d(TAG, JSONArray(message).toString(4))
                    else -> {
                        try {
                            Log.d(TAG, JSONObject(message).toString(4))
                        }catch (e: Exception) {
                            Log.d(TAG, message)
                        }
                    }
                }
            }
        })

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        client.addInterceptor(loggingInterceptor)

        client.connectTimeout(10, TimeUnit.SECONDS)
        client.readTimeout(10, TimeUnit.SECONDS)
        client.writeTimeout(10, TimeUnit.SECONDS)
        client.retryOnConnectionFailure(true)

        // 기본적인 retrofit 빌드
        if (retrofitClient == null) {
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build()) // 위에서 설정한 retrofit 클라이언트 설정
                .build()
        }

        return retrofitClient
    }
}