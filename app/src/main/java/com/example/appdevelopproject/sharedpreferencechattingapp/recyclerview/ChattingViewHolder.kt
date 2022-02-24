package com.example.appdevelopproject.sharedpreferencechattingapp.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.appdevelopproject.databinding.ChattingRecyclerItemBinding
import com.example.appdevelopproject.sharedpreferencechattingapp.data.ChattingInfo

class ChattingViewHolder(private val binding:ChattingRecyclerItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindData(data: ChattingInfo) {
        binding.chatItemName.text = data.username
        binding.chatItemComment.text = data.comment
        binding.chatItemTime.text = data.sendTime
    }
}