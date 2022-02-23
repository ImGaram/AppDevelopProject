package com.example.appdevelopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdevelopproject.retrofitbookapp.Constants.TAG
import com.example.appdevelopproject.retrofitbookapp.RESPONSE_STATE
import com.example.appdevelopproject.retrofitbookapp.recyclerview.BestSellerRecyclerViewAdapter
import com.example.appdevelopproject.retrofitbookapp.retrofit.RetrofitManager

class RetrofitActivity : AppCompatActivity() {
    private lateinit var adapter:BestSellerRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        Log.d(TAG, "onCreate - called")

        // 검색 api 호출
        RetrofitManager.instance.searchBooks(completion = { responseState, response ->
            when(responseState) {
                RESPONSE_STATE.OKAY -> {
                    Log.d(TAG, "onCreate - api 호출 성공 / response : ${response?.size}")

                    adapter = BestSellerRecyclerViewAdapter(response!!)
                    val recyclerView = findViewById<RecyclerView>(R.id.best_seller_recycler_view)
                    recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                    recyclerView.adapter = adapter
                }
                RESPONSE_STATE.FAIL -> {
                    Toast.makeText(this, "api 호출 에러 입니다.", Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "onCreate - api 호출 실패 / response : $response")
                }
            }
        })
    }
}