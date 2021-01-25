package com.infinitumcode.tinypokedex.domain.repository

import androidx.paging.PagingData
import com.infinitumcode.tinypokedex.domain.entity.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun fetchPokemonList(): Flow<PagingData<Pokemon>>
}