package com.example.appdevelopproject.rxjavaretrofitapp

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.appdevelopproject.R
import com.example.appdevelopproject.RxjavaRetrofitActivity
import com.example.appdevelopproject.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#20111111")
        window.navigationBarColor = Color.parseColor("#20111111")

        getInfo()
    }

    fun getInfo() {
        val user = intent.getStringExtra("name")
        val login = intent.getStringExtra("login")
        val avatarUrl = intent.getStringExtra("avatarUrl")
        val htmlUrl = intent.getStringExtra("htmlUrl")
        val followers = intent.getStringExtra("followers")
        val following = intent.getStringExtra("following")

        binding.userInfoUsername.text = user
        binding.userInfoLogin.text = login
        Glide.with(this)
            .load(avatarUrl)
            .into(binding.userInfoImage)
        binding.userInfoFollowers.text = followers
        binding.userInfoFollowing.text = following

        binding.moveHtmlBtn.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(htmlUrl)))
        }
    }
}