package com.example.appdevelopproject.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appdevelopproject.R
import com.example.appdevelopproject.databinding.ActivityDaggerHiltBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DaggerHiltActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDaggerHiltBinding
    @Inject
    private lateinit var test: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDaggerHiltBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.setTextView.text = test
    }
}
// @AndroidEntryPoint 를 사용하여 객체주입 대상으로 선언해주고,
// String 변수에 @Inject 를 사용하여 주입해준다.
// 여기에서 모든 모듈을 검색하여 String 문자열을 자동으로 찾아준다