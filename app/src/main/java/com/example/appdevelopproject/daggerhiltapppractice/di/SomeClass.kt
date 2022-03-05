package com.example.appdevelopproject.daggerhiltapppractice.di


import com.example.appdevelopproject.daggerhiltapppractice.module.Impl1
import com.example.appdevelopproject.daggerhiltapppractice.module.Impl2
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped     // 4
class SomeClass @Inject constructor(
    @Impl1 private val someInterfaceImpl1: SomeInterface,
    @Impl2 private val someInterfaceImpl2: SomeInterface
){  // 생성자 주입
    fun doAThing1(): String {
        return "Look I got: ${someInterfaceImpl1.getATing()}"   // getATing이 가지는 모든 걸 반환
    }

    fun doAThing2(): String {
        return "Look I got: ${someInterfaceImpl2.getATing()}"
    }
}