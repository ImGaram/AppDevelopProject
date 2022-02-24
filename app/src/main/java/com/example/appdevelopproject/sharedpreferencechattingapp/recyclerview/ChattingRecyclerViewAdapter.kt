package com.example.appdevelopproject.sharedpreferencechattingapp.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdevelopproject.databinding.ChattingRecyclerItemBinding
import com.example.appdevelopproject.sharedpreferencechattingapp.data.ChattingInfo

class ChattingRecyclerViewAdapter(var chatList: ArrayList<ChattingInfo>): RecyclerView.Adapter<ChattingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChattingViewHolder {
        val binding = ChattingRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChattingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChattingViewHolder, position: Int) {
        holder.bindData(chatList[position])
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}