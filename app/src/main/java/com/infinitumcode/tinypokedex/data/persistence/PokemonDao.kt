package com.infinitumcode.tinypokedex.data.persistence

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.infinitumcode.tinypokedex.data.entity.local.PokemonDb

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<PokemonDb>)

    @Query("SELECT * FROM Pokemon")
    fun allPokemon(): PagingSource<Int, PokemonDb>

    @Query("DELETE FROM Pokemon")
    suspend fun clearAllHits()
}