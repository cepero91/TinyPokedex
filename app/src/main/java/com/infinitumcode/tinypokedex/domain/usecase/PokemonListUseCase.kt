package com.infinitumcode.tinypokedex.domain.usecase

import com.infinitumcode.tinypokedex.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonListUseCase @Inject constructor(val repository: PokemonRepository){
    suspend operator fun invoke(page: Int) = repository.fetchPokemonList(page)
}