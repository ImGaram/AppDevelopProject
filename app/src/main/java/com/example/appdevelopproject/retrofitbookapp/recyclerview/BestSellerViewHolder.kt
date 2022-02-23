package com.example.appdevelopproject.retrofitbookapp.recyclerview

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appdevelopproject.R
import com.example.appdevelopproject.retrofitbookapp.App
import com.example.appdevelopproject.retrofitbookapp.BookInfoActivity
import com.example.appdevelopproject.retrofitbookapp.Constants.TAG
import com.example.appdevelopproject.retrofitbookapp.data.Book

class BestSellerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var context: Context

    private val titleText = itemView.findViewById<TextView>(R.id.book_title_text)
    private val rankText = itemView.findViewById<TextView>(R.id.book_ranking_text)
    private val authorText = itemView.findViewById<TextView>(R.id.book_author_text)
    private val publisherText = itemView.findViewById<TextView>(R.id.book_publisher_text)
    private val reviewRankText = itemView.findViewById<TextView>(R.id.book_review_rank_text)
    private val mainPageImage = itemView.findViewById<ImageView>(R.id.book_main_sign)

    fun bindItem(bookItem: Book) {
        Log.d(TAG, "bindItem - called")

        itemView.setOnClickListener {
            context = itemView.context
            Intent(context, BookInfoActivity::class.java).apply {
                putExtra("title", bookItem.title)
                putExtra("image", bookItem.coverLargeUrl)
                putExtra("author", bookItem.author)
                putExtra("publisher", bookItem.publisher)
                putExtra("description", bookItem.description)
                putExtra("url", bookItem.mobileLink)
            }.run {
                context.startActivity(this)
                Log.d(TAG, "bindItem - called  intent success / item : $bookItem")
            }
        }

        titleText.text = bookItem.title
        rankText.text = bookItem.rank
        authorText.text = bookItem.author
        publisherText.text = bookItem.publisher
        reviewRankText.text = bookItem.customerReviewRank.toString()

        Glide.with(App.instance)
            .load(bookItem.coverLargeUrl)
            .placeholder(R.drawable.ic_baseline_insert_photo_24)
            .into(mainPageImage)
    }
}