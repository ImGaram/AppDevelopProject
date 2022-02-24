package com.example.appdevelopproject.sharedpreferencechattingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appdevelopproject.databinding.ActivityChattingBinding
import com.example.appdevelopproject.retrofitbookapp.Constants.TAG
import com.example.appdevelopproject.sharedpreferencechattingapp.data.ChattingInfo
import com.example.appdevelopproject.sharedpreferencechattingapp.recyclerview.ChattingRecyclerViewAdapter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ChattingActivity : AppCompatActivity() {

    private lateinit var chatting: ArrayList<ChattingInfo>
    private lateinit var binding:ActivityChattingBinding
    private lateinit var adapter: ChattingRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChattingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "ChattingActivity - onCreate() called")

        val name = intent.getStringExtra("user")
        val pref = getSharedPreferences("chat", 0)
        val editor = pref.edit()
        editor.putString("username", name)

        chatting = arrayListOf()

        refreshRecyclerView()   // recyclerview build

        binding.chatTextArea.setEndIconOnClickListener {
            val comment = binding.chatInputText.text.toString()

            if (comment.isNotEmpty()) {
                val time = System.currentTimeMillis()
                val date = Date(time)
                val dateFormat = SimpleDateFormat("MM/dd\nhh:mm")
                val getTime = dateFormat.format(date)

                editor.putString("usercomment", comment)
                editor.putString("usersendTime", getTime)
                editor.apply()

                val getName: String? = pref.getString("username", "")
                val getComment: String? = pref.getString("usercomment", "")
                val getSendTime: String? = pref.getString("usersendTime", "")
                Log.d(TAG, "ChattingActivity - onCreate() called / getData : $getName")
                Log.d(TAG, "ChattingActivity - onCreate() called / getData : $getComment")
                Log.d(TAG, "ChattingActivity - onCreate() called / getData : $getSendTime")

                chatting.add(ChattingInfo(getName, getComment, getSendTime))
                Log.d(TAG, "ChattingActivity - onCreate() called / data : $chatting")

                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun refreshRecyclerView() {
        val recyclerView = binding.chatRecyclerView
        adapter = ChattingRecyclerViewAdapter(chatting)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }
}