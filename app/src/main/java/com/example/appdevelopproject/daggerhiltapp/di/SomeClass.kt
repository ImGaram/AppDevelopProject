package com.example.appdevelopproject.daggerhiltapp.di

import com.example.appdevelopproject.daggerhiltapp.implementation.SomeInterfaceImpl
import com.google.gson.Gson
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class SomeClass @Inject constructor(
    private val someInterfaceImpl: SomeInterfaceImpl,
    private val gson: Gson
){  // 생성자 주입
    fun doAThing(): String {
        return "Look I got: ${someInterfaceImpl.getATing()}"   // getATing이 가지는 모든 걸 반환
    }
}