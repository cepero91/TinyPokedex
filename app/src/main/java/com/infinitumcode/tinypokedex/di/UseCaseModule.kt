package com.infinitumcode.tinypokedex.di

import com.infinitumcode.tinypokedex.domain.repository.PokemonRepository
import com.infinitumcode.tinypokedex.domain.usecase.PokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun providePokemonListUseCase(
        pokemonRepository: PokemonRepository
    ): PokemonListUseCase {
        return PokemonListUseCase(pokemonRepository)
    }

}