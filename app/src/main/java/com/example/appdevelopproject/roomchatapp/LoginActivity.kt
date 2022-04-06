package com.example.appdevelopproject.roomchatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.appdevelopproject.R
import com.example.appdevelopproject.RoomChatActivity
import com.example.appdevelopproject.databinding.ActivityLoginBinding
import com.example.appdevelopproject.roomchatapp.db.UserDbBuilder
import com.example.appdevelopproject.roomchatapp.entity.UserEntity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    var userDb: UserDbBuilder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userDb = UserDbBuilder.getInstance(this)

        binding.goChatBtn.setOnClickListener {
            adduser()
        }
    }

    private fun adduser() {
        val id = binding.userId.text.toString()
        val username = binding.userUsername.text.toString()
        val userEntity = UserEntity(id, username)

        // 값이 비지 않은 경우
        if (id.isNotEmpty() && username.isNotEmpty()) {
            userDb?.userDao()?.insert(userEntity)
            Log.d("TAG", "adduser db data: ${userDb?.userDao()?.getAll().toString()}")
            startActivity(Intent(this, RoomChatActivity::class.java))
        } else {    // 빈 경우
            Toast.makeText(this, "모두 입력 하세요", Toast.LENGTH_SHORT).show()
        }
    }
}