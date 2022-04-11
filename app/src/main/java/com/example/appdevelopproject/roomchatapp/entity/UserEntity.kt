package com.example.appdevelopproject.roomchatapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class UserEntity(
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,      // user number
    @ColumnInfo(name = "id") var id: String,                // id
    @ColumnInfo(name = "username") var username: String,    // username
    @ColumnInfo(name = "comment") var comment: String
) {
    constructor(): this(0, "", "", "")  // default 값
}
