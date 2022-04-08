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

    // 삽입 쿼리
    // onConflict: 중복된 기본 키 값이 데이터베이스 내에 존재할 경우 대체함
    @Insert(onConflict = REPLACE)
    fun insert(userEntity: UserEntity)

    // 특정 데이터 삭제 쿼리
    @Query("DELETE from user_table WHERE id = :id")
    fun deleteAll(id: String)
}