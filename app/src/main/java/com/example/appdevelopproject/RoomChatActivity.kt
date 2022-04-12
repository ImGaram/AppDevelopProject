package com.example.appdevelopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdevelopproject.databinding.ActivityRoomChatBinding
import com.example.appdevelopproject.roomchatapp.db.ChatDbBuilder
import com.example.appdevelopproject.roomchatapp.entity.ChatEntity
import com.example.appdevelopproject.roomchatapp.recyclerview.ChattingRecyclerAdapter
import java.text.SimpleDateFormat
import java.util.*

class RoomChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoomChatBinding
    private lateinit var chatDbBuilder: ChatDbBuilder
    private lateinit var chatList: List<ChatEntity>
    private lateinit var chatDb: ChatDbBuilder
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRoomChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chatDbBuilder = ChatDbBuilder.getInstance(this)!!
        chatDb = ChatDbBuilder.getInstance(this)!!
        var adapter: ChattingRecyclerAdapter
        binding.chatUserId.text = intent.getStringExtra("id").toString()
        Log.d("TAG", "intent putExtra: ${intent.getStringExtra("image")}")

        val r = Runnable {
            try {
                chatList = chatDb.chatDao().getAll()
                adapter = ChattingRecyclerAdapter(this, chatList)
                adapter.notifyDataSetChanged()
                recyclerView = binding.chatRecyclerView
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.setHasFixedSize(true)
            } catch (e: Exception) {
                Log.e("ERROR", "$e")
            }
        }

        binding.imageSendComment.setOnClickListener {
            if (binding.chatComment.text.isNotEmpty()) {
                addData()
            } else {
                Toast.makeText(this, " 비었어요", Toast.LENGTH_SHORT).show()
            }
        }

        val thread = Thread(r)
        thread.start()
    }

    private fun addData() {
        val addRunnable = Runnable {
            val newChat = ChatEntity()
            newChat.sendId = intent.getStringExtra("id").toString()
            newChat.comment = binding.chatComment.text.toString()
            Log.d("TEST", "addData comment: ${newChat.comment}")

            // 시간 구하기
            val now = System.currentTimeMillis()
            val date = Date(now)
            val dateFormat = SimpleDateFormat("MM/dd hh:ss", Locale.KOREA)
            val getTime = dateFormat.format(date)

            newChat.sendTime = getTime.toString()
            chatDb.chatDao().insert(newChat)
        }

        val addThread = Thread(addRunnable)
        addThread.start()
    }
}