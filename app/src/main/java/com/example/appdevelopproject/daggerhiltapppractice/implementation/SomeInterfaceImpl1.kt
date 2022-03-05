package com.example.appdevelopproject.daggerhiltapppractice.implementation

import com.example.appdevelopproject.daggerhiltapppractice.di.SomeInterface
import javax.inject.Inject

class SomeInterfaceImpl1 @Inject constructor(): SomeInterface { // 2
    override fun getATing(): String {
        return "A Thing1"
    }
}