package com.example.appdevelopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appdevelopproject.databinding.ActivityRoomChatBinding

class RoomChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoomChatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRoomChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}