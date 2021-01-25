package com.infinitumcode.tinypokedex.data.datasource.local

import androidx.paging.PagingSource
import com.infinitumcode.tinypokedex.data.entity.local.PokemonDb
import com.infinitumcode.tinypokedex.data.entity.local.RemoteKeyDb

interface LocalDataSource {
    fun allPokemon(): PagingSource<Int, PokemonDb>
    suspend fun remoteKeyByName(pokemonName: String): RemoteKeyDb?
    suspend fun onDatabaseTransaction(operation: suspend () -> Unit)
    suspend fun removeAllPokemon()
    suspend fun removeAllKeys()
    suspend fun insertAllPokemon(pokemonList: List<PokemonDb>)
    suspend fun insertAllKey(keyList: List<RemoteKeyDb>)
}