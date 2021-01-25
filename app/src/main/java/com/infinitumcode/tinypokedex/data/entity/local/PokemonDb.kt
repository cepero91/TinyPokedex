package com.infinitumcode.tinypokedex.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Pokemon")
data class PokemonDb(
    @PrimaryKey
    val name: String,
    val url: String
)
