package com.example.appdevelopproject.daggerhiltapp.implementation

import com.example.appdevelopproject.daggerhiltapp.di.SomeInterface
import javax.inject.Inject

class SomeInterfaceImpl @Inject constructor(
    private val someDependency: String
): SomeInterface {
    override fun getATing(): String {
        return "A Thing, $someDependency"
    }
}