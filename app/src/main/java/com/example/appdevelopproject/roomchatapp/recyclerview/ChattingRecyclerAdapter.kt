package com.example.appdevelopproject.roomchatapp.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdevelopproject.databinding.RecyclerviewItemChatBinding
import com.example.appdevelopproject.roomchatapp.entity.ChatEntity

class ChattingRecyclerAdapter: RecyclerView.Adapter<ChattingRecyclerAdapter.ViewHolder>() {

    private var chatList = emptyList<ChatEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerviewItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = chatList[position]
        holder.binding.recyclerViewItemId.text = currentItem.sendId
        holder.binding.recyclerViewItemComment.text = currentItem.comment
        holder.binding.recyclerViewItemTime.text = currentItem.sendTime
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(chat: List<ChatEntity>) {
        chatList = chat
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: RecyclerviewItemChatBinding): RecyclerView.ViewHolder(binding.root)
}