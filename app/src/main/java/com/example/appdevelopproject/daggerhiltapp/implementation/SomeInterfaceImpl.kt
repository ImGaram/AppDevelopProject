package com.example.appdevelopproject.daggerhiltapp.implementation

import com.example.appdevelopproject.daggerhiltapp.di.SomeInterface
import javax.inject.Inject

class SomeInterfaceImpl @Inject constructor(): SomeInterface {
    override fun getATing(): String {
        return "A Thing"
    }
}