package com.infinitumcode.tinypokedex.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Remote_Key")
data class RemoteKeyDb(
    @PrimaryKey
    val name: String,
    val nextKey: Int?
)
