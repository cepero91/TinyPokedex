package com.infinitumcode.tinypokedex.data.entity.local

import androidx.room.Entity

@Entity(tableName = "Remote_Key")
data class RemoteKeyDb(
    val name: String,
    val nextKey: Int
)
