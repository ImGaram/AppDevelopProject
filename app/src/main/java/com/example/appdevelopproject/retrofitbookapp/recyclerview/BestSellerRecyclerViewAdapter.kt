package com.example.appdevelopproject.retrofitbookapp.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdevelopproject.R
import com.example.appdevelopproject.retrofitbookapp.data.Book

class BestSellerRecyclerViewAdapter(var bookList: ArrayList<Book>): RecyclerView.Adapter<BestSellerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_seller_item, parent, false)
        return BestSellerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        holder.bindItem(this.bookList[position])
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}