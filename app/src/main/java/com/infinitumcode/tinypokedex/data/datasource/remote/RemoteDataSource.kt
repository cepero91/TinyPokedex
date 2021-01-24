package com.infinitumcode.tinypokedex.data.datasource.remote

import com.infinitumcode.tinypokedex.data.entity.remote.PokemonResponseDto
import com.infinitumcode.tinypokedex.data.wrapper.Result

interface RemoteDataSource {
    suspend fun fetchPokemonList(page: Int): Result<PokemonResponseDto>
}