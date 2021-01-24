package com.infinitumcode.tinypokedex.data.datasource.local

import androidx.paging.PagingSource
import com.infinitumcode.tinypokedex.data.entity.local.PokemonDb
import com.infinitumcode.tinypokedex.data.entity.local.RemoteKeyDb

interface LocalDataSource {
    fun allPokemon(): PagingSource<Int, PokemonDb>
    suspend fun remoteKeyByName(pokemonName: String): RemoteKeyDb?
}