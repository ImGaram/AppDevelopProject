package com.example.appdevelopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appdevelopproject.databinding.ActivityRoomChatBinding
import com.example.appdevelopproject.roomchatapp.db.ChatDbBuilder

class RoomChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoomChatBinding
    private lateinit var chatDbBuilder: ChatDbBuilder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRoomChatBinding.inflate(layoutInflater)

        chatDbBuilder = ChatDbBuilder.getInstance(this)!!

        val r = Runnable {

        }

        val thread = Thread(r)
        thread.start()
        setContentView(binding.root)
    }
}