package com.infinitumcode.tinypokedex.data.entity.remote

data class PokemonResponseDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonDto>
)