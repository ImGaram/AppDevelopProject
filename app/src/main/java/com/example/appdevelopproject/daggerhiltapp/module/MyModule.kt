package com.example.appdevelopproject.daggerhiltapp.module

import com.example.appdevelopproject.daggerhiltapp.di.SomeInterface
import com.example.appdevelopproject.daggerhiltapp.implementation.SomeInterfaceImpl1
import com.example.appdevelopproject.daggerhiltapp.implementation.SomeInterfaceImpl2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MyModule {    // 3
    @Impl1
    @Singleton  // @InstallIn의 component에 따라 적절히 변경
    @Provides
    fun provideSomeInterface1(): SomeInterface {
        return SomeInterfaceImpl1()
    }

    @Impl2
    @Singleton
    @Provides
    fun provideSomeInterface2(): SomeInterface {
        return SomeInterfaceImpl2()
    }
}

// 커스텀 어노테이션
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2