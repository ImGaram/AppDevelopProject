package com.example.appdevelopproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.appdevelopproject.databinding.ActivitySharedPreferenceBinding
import com.example.appdevelopproject.sharedpreferencechattingapp.ChattingActivity

class SharedPreferenceActivity : AppCompatActivity() {

    private val TAG = "로그"
    private lateinit var binding: ActivitySharedPreferenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySharedPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "SharedPreferenceActivity - onCreate() called")

        binding.chatMoveBtn.setOnClickListener {
            val name = binding.chatEditTextName.text.toString()     // 이름
            Log.d(TAG, "SharedPreferenceActivity - onCreate() called / data : $name")
            binding.chatEditTextName.text?.clear()

            Toast.makeText(this, "$name 으로 설정 완료", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ChattingActivity::class.java)
                .putExtra("user", name)
            startActivity(intent)
        }
    }
}