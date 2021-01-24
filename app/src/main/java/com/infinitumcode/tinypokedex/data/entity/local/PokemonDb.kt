package com.infinitumcode.tinypokedex.data.entity.local

import androidx.room.Entity

@Entity(tableName = "Pokemon")
data class PokemonDb(
    val name: String,
    val url: String
)
