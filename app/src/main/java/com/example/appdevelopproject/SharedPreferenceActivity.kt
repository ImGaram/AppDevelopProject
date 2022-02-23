package com.example.appdevelopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appdevelopproject.databinding.ActivitySharedPreferenceBinding

class SharedPreferenceActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPreferenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySharedPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chatMoveBtn.setOnClickListener {
            binding.chatEditTextName.text?.clear()
        }
    }
}