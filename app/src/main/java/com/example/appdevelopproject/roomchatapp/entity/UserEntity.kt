package com.example.appdevelopproject.roomchatapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class UserEntity(
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    @ColumnInfo(name = "id") var id: String,
    @ColumnInfo(name = "username") var username: String,
    @ColumnInfo(name = "profileImg") var profileImg: String
) {
    constructor(): this(0, "", "", "")  // default 값
}
