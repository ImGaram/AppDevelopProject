package com.example.appdevelopproject.roomchatapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appdevelopproject.roomchatapp.entity.UserDao
import com.example.appdevelopproject.roomchatapp.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDbBuilder: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: UserDbBuilder? = null

        fun getInstance(context: Context): UserDbBuilder? {
            if (INSTANCE == null) {
                synchronized(UserDbBuilder::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        UserDbBuilder::class.java, "user_table")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}