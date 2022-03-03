package com.example.appdevelopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appdevelopproject.daggerhiltapp.BaseApplication
import com.example.appdevelopproject.daggerhiltapp.di.SomeClass
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DaggerHiltActivity : AppCompatActivity() {
    private val TAG = "DaggerHiltActivity"

    @Inject
    lateinit var app: BaseApplication
    @Inject
    lateinit var someRandomString: String
    // field injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_hilt)

        Log.d(TAG, "onCreate: ${someClass.doAThing()}")
        Log.d(TAG, "onCreate: $someRandomString")
        Log.d(TAG, "onCreate: $app")
    }
}