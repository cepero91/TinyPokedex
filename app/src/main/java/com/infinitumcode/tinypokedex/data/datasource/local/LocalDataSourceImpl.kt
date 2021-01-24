package com.infinitumcode.tinypokedex.data.datasource.local

import androidx.paging.PagingSource
import com.infinitumcode.tinypokedex.data.entity.local.PokemonDb
import com.infinitumcode.tinypokedex.data.entity.local.RemoteKeyDb
import com.infinitumcode.tinypokedex.data.persistence.PokemonDatabase
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val pokemonDatabase: PokemonDatabase) : LocalDataSource {
    override fun allPokemon(): PagingSource<Int, PokemonDb> {
        return pokemonDatabase.pokemonDao().allPokemon()
    }

    override suspend fun remoteKeyByName(pokemonName: String): RemoteKeyDb? {
        return pokemonDatabase.remoteKeysDao().remoteKeysByName(pokemonName)
    }
}