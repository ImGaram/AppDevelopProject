package com.example.appdevelopproject.roomchatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appdevelopproject.R
import com.example.appdevelopproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}