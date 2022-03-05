package com.example.appdevelopproject.daggerhiltapp.implementation

import com.example.appdevelopproject.daggerhiltapp.di.SomeInterface
import javax.inject.Inject

class SomeInterfaceImpl1 @Inject constructor(): SomeInterface { // 2
    override fun getATing(): String {
        return "A Thing1"
    }
}