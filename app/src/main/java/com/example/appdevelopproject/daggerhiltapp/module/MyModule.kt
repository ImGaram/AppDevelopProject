package com.example.appdevelopproject.daggerhiltapp.module

import com.example.appdevelopproject.daggerhiltapp.di.SomeInterface
import com.example.appdevelopproject.daggerhiltapp.implementation.SomeInterfaceImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MyModule {
    @Singleton  // @InstallIn의 component에 따라 적절히 변경
    @Provides
    fun provideSomeInterface(someString: String): SomeInterface {
        return SomeInterfaceImpl(someString)
    }

    @Singleton
    @Provides
    fun provideSomeString(): String {
        return "Some String"
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}