package com.infinitumcode.tinypokedex.domain.usecase

import com.infinitumcode.tinypokedex.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonListUseCase @Inject constructor(private val repository: PokemonRepository){
     operator fun invoke() = repository.fetchPokemonList()
}