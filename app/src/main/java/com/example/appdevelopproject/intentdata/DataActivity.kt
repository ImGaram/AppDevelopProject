package com.example.appdevelopproject.intentdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.example.appdevelopproject.R

class DataActivity : AppCompatActivity(), RedFragment.OnListenerRed, GreenFragment.OnListenerGreen {

    private val fragmentManager = supportFragmentManager
    private lateinit var transaction: FragmentTransaction
    private var isRed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, RedFragment())
        transaction.add(R.id.frameLayout, GreenFragment())
        transaction.commit()

        val btnChange = findViewById<Button>(R.id.btnChange)
        btnChange.setOnClickListener {

            transaction = fragmentManager.beginTransaction()

            if (isRed) {
                transaction.replace(R.id.frameLayout, GreenFragment())
            } else {
                transaction.replace(R.id.frameLayout, RedFragment())
            }

            isRed = !isRed
            transaction.commit()

        }
    }

    override fun onReceivedData(name: String) {
        val tvMain = findViewById<TextView>(R.id.tvMain)
        tvMain.text = name
    }
}