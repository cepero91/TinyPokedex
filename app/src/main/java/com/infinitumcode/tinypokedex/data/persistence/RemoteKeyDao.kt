package com.infinitumcode.tinypokedex.data.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.infinitumcode.tinypokedex.data.entity.local.RemoteKeyDb

@Dao
interface RemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeyDb>)

    @Query("SELECT * FROM Remote_Key WHERE name = :pokemonName")
    suspend fun remoteKeysByName(pokemonName: String): RemoteKeyDb?

    @Query("DELETE FROM Remote_Key")
    suspend fun clearRemoteKeys()
}