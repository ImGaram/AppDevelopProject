package com.example.appdevelopproject.roomchatapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chat_table")
class ChatEntity(
    @PrimaryKey(autoGenerate = true) var uid: Long,
    @ColumnInfo(name = "sendId") var sendId: String,        // 보낸 사람의 id
    @ColumnInfo(name = "comment") var comment: String,      // 보낸 글
    @ColumnInfo(name = "sendTime") var sendTime: String     // 보낸 시간
) {
    constructor(): this(0, "", "", "00:00")
}