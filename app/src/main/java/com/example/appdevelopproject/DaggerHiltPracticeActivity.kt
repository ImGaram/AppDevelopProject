package com.example.appdevelopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appdevelopproject.daggerhiltapppractice.BaseApplication
import com.example.appdevelopproject.daggerhiltapppractice.di.SomeClass
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DaggerHiltPracticeActivity : AppCompatActivity() {    // 5
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
        setContentView(R.layout.activity_dagger_hilt_practice)

        Log.d(TAG, "onCreate: ${someClass.doAThing1()}")
        Log.d(TAG, "onCreate: ${someClass.doAThing2()}")
        Log.d(TAG, "onCreate: $someRandomString")
        Log.d(TAG, "onCreate: $app")
    }
}