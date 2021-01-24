package com.infinitumcode.tinypokedex.data.datasource.remote

import com.infinitumcode.tinypokedex.data.entity.remote.PokemonResponseDto
import com.infinitumcode.tinypokedex.data.network.NetworkRequestHelper
import com.infinitumcode.tinypokedex.data.network.PokemonService
import com.infinitumcode.tinypokedex.data.wrapper.Result
import com.infinitumcode.tinypokedex.utils.Constants.PAGE_SIZE
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val pokemonService: PokemonService) :
    NetworkRequestHelper(), RemoteDataSource {
    override suspend fun fetchPokemonList(page: Int): Result<PokemonResponseDto> {
        return safeApiCall { pokemonService.fetchPokemonList(PAGE_SIZE, page * PAGE_SIZE) }
    }
}