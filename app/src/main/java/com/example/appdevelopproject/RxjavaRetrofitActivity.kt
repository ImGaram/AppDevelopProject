package com.example.appdevelopproject

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.appdevelopproject.databinding.ActivityRxjavaRetrofitBinding
import com.example.appdevelopproject.rxjavaretrofitapp.GithubClient
import com.example.appdevelopproject.rxjavaretrofitapp.UserInfoActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxjavaRetrofitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRxjavaRetrofitBinding
    private val TAG = "RxjavaApp"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // status bar, navigation bar 반투명하게
        window.statusBarColor = Color.parseColor("#20111111")
        window.navigationBarColor = Color.parseColor("#20111111")

        binding = ActivityRxjavaRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editTextSearchUserName = binding.editTextSearchUsername
        binding.buttonShowInfo.setOnClickListener {
            val usernameText = editTextSearchUserName.text.toString()
            getApi(usernameText)
            Log.d(TAG, "userName: $usernameText")
        }
    }

    @SuppressLint("CheckResult")
    fun getApi(username: String) {
        GithubClient.getApi().getUsers(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ items ->
                Log.d(TAG, "success: $items")
                val intent = Intent(this, UserInfoActivity::class.java)
                    .putExtra("name", items.name)
                    .putExtra("login", items.login)
                    .putExtra("avatarUrl", items.avatarUrl)
                    .putExtra("htmlUrl", items.htmlUrl)
                    .putExtra("followers", items.followers)
                    .putExtra("following", items.following)
                startActivity(intent)
            }, { e ->
                Log.d(TAG, "failed: $e")
            })
    }
}