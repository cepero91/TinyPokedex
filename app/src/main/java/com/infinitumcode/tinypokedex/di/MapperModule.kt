package com.infinitumcode.tinypokedex.di

import com.infinitumcode.tinypokedex.data.entity.local.PokemonDb
import com.infinitumcode.tinypokedex.data.entity.remote.PokemonDto
import com.infinitumcode.tinypokedex.data.mapper.Mapper
import com.infinitumcode.tinypokedex.data.mapper.PokemonDbToDomain
import com.infinitumcode.tinypokedex.data.mapper.PokemonDtoToDb
import com.infinitumcode.tinypokedex.domain.entity.Pokemon
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindPokemonDbToDomain(pokemonDbToDomain: PokemonDbToDomain): Mapper<PokemonDb, Pokemon>

    @Binds
    abstract fun bindPokemonDtoToDb(pokemonDtoToDb: PokemonDtoToDb): Mapper<PokemonDto, PokemonDb>
}