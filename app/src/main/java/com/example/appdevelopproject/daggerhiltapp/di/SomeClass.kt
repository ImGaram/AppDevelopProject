package com.example.appdevelopproject.daggerhiltapp.di

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class SomeClass @Inject constructor(){  // 생성자 주입
    fun doAThing(): String {
        return "Look I did a thing!"
    }
}