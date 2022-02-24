package com.example.appdevelopproject.sharedpreferencechattingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appdevelopproject.R
import com.example.appdevelopproject.databinding.ActivityChattingBinding
import com.example.appdevelopproject.retrofitbookapp.Constants.TAG
import com.example.appdevelopproject.sharedpreferencechattingapp.data.ChattingInfo
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ChattingActivity : AppCompatActivity() {

    private lateinit var chatting: ArrayList<ChattingInfo>
    private lateinit var binding:ActivityChattingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChattingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "ChattingActivity - onCreate() called")

        val name = intent.getStringExtra("user")

        chatting = arrayListOf()
        binding.chatTextArea.setEndIconOnClickListener {
            val comment = binding.chatInputText.text.toString()

            if (comment.isNotEmpty()) {
                val time = System.currentTimeMillis()
                val date = Date(time)
                val dateFormat = SimpleDateFormat("MM/dd\nhh:mm")
                val getTime = dateFormat.format(date)

                chatting.add(ChattingInfo(name, comment, getTime))
                Log.d(TAG, "ChattingActivity - onCreate() called / data : $chatting")
            }
        }
    }
}