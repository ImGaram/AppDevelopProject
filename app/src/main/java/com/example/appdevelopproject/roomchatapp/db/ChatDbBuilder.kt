package com.example.appdevelopproject.roomchatapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appdevelopproject.roomchatapp.entity.ChatDao
import com.example.appdevelopproject.roomchatapp.entity.ChatEntity

@Database(entities = [ChatEntity::class], version = 1)
abstract class ChatDbBuilder: RoomDatabase() {
    abstract fun chatDao(): ChatDao

    companion object {
        private var INSTANCE: ChatDbBuilder? = null

        fun getInstance(context: Context): ChatDbBuilder? {
            if (INSTANCE == null) {
                synchronized(ChatDbBuilder::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ChatDbBuilder::class.java, "chat_table")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}