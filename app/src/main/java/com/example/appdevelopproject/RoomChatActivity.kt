package com.example.appdevelopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
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
    private lateinit var adapter: ChattingRecyclerAdapter

    private lateinit var r: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRoomChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chatDbBuilder = ChatDbBuilder.getInstance(this)!!
        chatDb = ChatDbBuilder.getInstance(this)!!
        binding.chatUserId.text = intent.getStringExtra("id").toString()

        setRecyclerView()
        binding.swipe.setOnRefreshListener {
            val thread = Thread(r)
            thread.interrupt()  // 스레드 중지
            setRecyclerView()
            binding.swipe.isRefreshing = false  // 새로고침 완료
        }

        binding.imageSendComment.setOnClickListener {
            if (binding.chatComment.text.isNotEmpty()) {
                addData()
            } else {
                Toast.makeText(this, " 비었어요", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setRecyclerView() {
        r = Runnable {
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