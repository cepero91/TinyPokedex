package com.infinitumcode.tinypokedex.data.network

import com.infinitumcode.tinypokedex.data.entity.remote.PokemonResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonResponseDto
}