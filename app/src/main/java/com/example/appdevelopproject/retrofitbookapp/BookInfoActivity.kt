package com.example.appdevelopproject.retrofitbookapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import com.bumptech.glide.Glide
import com.example.appdevelopproject.R
import com.example.appdevelopproject.databinding.ActivityBookInfoBinding
import com.example.appdevelopproject.retrofitbookapp.Constants.TAG

class BookInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBookInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "BookInfoActivity - onCreate() called")

        val title = intent.getStringExtra("title")
        Log.d(TAG, "BookInfoActivity - onCreate() called / title: $title")
        binding.bookInfoToolBar.title = title

        val image = intent.getStringExtra("image")
        Log.d(TAG, "BookInfoActivity - onCreate() called / image: $image")
        Glide.with(App.instance)
            .load(image)
            .placeholder(R.drawable.ic_baseline_insert_photo_24)
            .into(binding.bookInfoImage)

        val author = intent.getStringExtra("author")
        Log.d(TAG, "BookInfoActivity - onCreate() called / author: $author")
        binding.bookInfoAuthor.text = "지은이 : $author"

        val publisher = intent.getStringExtra("publisher")
        Log.d(TAG, "BookInfoActivity - onCreate() called / publisher: $publisher")
        binding.bookInfoPublisher.text = "출판사 : $publisher"

        val description = intent.getStringExtra("description")
        Log.d(TAG, "BookInfoActivity - onCreate() called / description: $description")
        binding.bookInfoDescription.text = description
        binding.bookInfoDescription.movementMethod = ScrollingMovementMethod()

        val url = intent.getStringExtra("url")
        binding.bookInfoMobileLinkButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        binding.bookInfoToolBar.setNavigationOnClickListener {
            finish()
        }
    }
}