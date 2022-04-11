package com.example.appdevelopproject.roomchatapp.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ChatDao {
    // 전체 선택 쿼리
    @Query("SELECT * FROM user_table")
    fun getAll(): List<ChatEntity>

    // 삽입 쿼리
    @Insert
    fun insert(userEntity: ChatEntity)
}