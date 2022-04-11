package com.example.appdevelopproject.roomchatapp.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdevelopproject.databinding.RecyclerviewItemChatBinding
import com.example.appdevelopproject.roomchatapp.entity.ChatEntity

class ChattingRecyclerAdapter(val context: Context, var chatList: List<ChatEntity>)
    : RecyclerView.Adapter<ChattingRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerviewItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chatList[position])
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(chat: List<ChatEntity>) {
        chatList = chat
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: RecyclerviewItemChatBinding): RecyclerView.ViewHolder(binding.root) {
        val id = binding.recyclerViewItemId
        val comment = binding.recyclerViewItemComment
        val time = binding.recyclerViewItemTime

        fun bind(chatEntity: ChatEntity) {
            id.text = chatEntity.sendId
            comment.text = chatEntity.comment
            time.text = chatEntity.sendTime
        }
    }
}