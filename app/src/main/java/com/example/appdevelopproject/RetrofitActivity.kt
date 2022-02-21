package com.example.appdevelopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.appdevelopproject.retrofitbookapp.Constants.TAG
import com.example.appdevelopproject.retrofitbookapp.RESPONSE_STATE
import com.example.appdevelopproject.retrofitbookapp.retrofit.RetrofitManager

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val searchButton = this.findViewById<Button>(R.id.search_button)
        searchButton.setOnClickListener {
            Log.d(TAG, "onCreate - 검색 버튼이 클릭됨")

            // 검색 api 호출
            RetrofitManager.instance.searchBooks(completion = { responseState, response ->
                when(responseState) {
                    RESPONSE_STATE.OKAY -> {
                        Log.d(TAG, "onCreate - api 호출 성공 / response : $response")
                    }
                    RESPONSE_STATE.FAIL -> {
                        Toast.makeText(this, "api 호출 에러 입니다.", Toast.LENGTH_SHORT).show()
                        Log.d(TAG, "onCreate - api 호출 실패 / response : $response")
                    }
                }
            })
        }
    }
}