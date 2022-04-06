package com.example.appdevelopproject.roomchatapp.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface UserDao {
    // 검색 쿼리
    @Query("SELECT * FROM user_table")
    fun getAll(): List<UserEntity>

    // 삭제 쿼리
    @Insert(onConflict = REPLACE)
    fun insert(userEntity: UserEntity)

    // 삭제 쿼리
    @Query("DELETE from user_table")
    fun deleteAll()
}