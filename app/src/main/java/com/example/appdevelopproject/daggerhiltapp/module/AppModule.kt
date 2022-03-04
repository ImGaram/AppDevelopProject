package com.example.appdevelopproject.daggerhiltapp.module

import android.content.Context
import com.example.appdevelopproject.daggerhiltapp.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // 응용 프로그램 context에 엑세스 하기를 원하는 경우 사용
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideRandomString(): String {
        return "Hey look a random String!!"
    }
}