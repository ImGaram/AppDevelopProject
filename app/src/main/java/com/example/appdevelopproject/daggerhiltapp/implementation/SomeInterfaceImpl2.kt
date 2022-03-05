package com.example.appdevelopproject.daggerhiltapp.implementation

import com.example.appdevelopproject.daggerhiltapp.di.SomeInterface
import javax.inject.Inject

class SomeInterfaceImpl2 @Inject constructor(): SomeInterface { // 2
    override fun getATing(): String {
        return "A Thing2"
    }
}