package com.infinitumcode.tinypokedex.di

import com.infinitumcode.tinypokedex.data.repository.PokemonRemoteMediator
import com.infinitumcode.tinypokedex.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPokemonRemoteMediator(pokemonRemoteMediator: PokemonRemoteMediator): PokemonRepository

}