package com.infinitumcode.tinypokedex.data.entity.remote

/**
 * A customized pokemon error response.
 *
 * @param code A network response code.
 * @param message A network error message.
 */
data class PokemonErrorResponseDto(
  val code: Int,
  val message: String?
)
