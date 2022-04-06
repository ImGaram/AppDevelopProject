package com.example.appdevelopproject.roomchatapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class UserEntity(
    @PrimaryKey var id: String?,
    @ColumnInfo(name = "username") var username: String
) {
    constructor(): this(null, "")
}
