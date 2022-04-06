package com.example.appdevelopproject.roomchatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appdevelopproject.R
import com.example.appdevelopproject.RoomChatActivity
import com.example.appdevelopproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goChatBtn.setOnClickListener {
            adduser()
        }
    }

    private fun adduser() {
        val id = binding.userId
        val username = binding.userUsername

        // 값이 비지 않은 경우
        if (id.text.toString().isNotEmpty() && username.text.toString().isNotEmpty()) {
            startActivity(Intent(this, RoomChatActivity::class.java))
        } else {    // 빈 경우
            Toast.makeText(this, "모두 입력 하세요", Toast.LENGTH_SHORT).show()
        }
    }
}