package com.infinitumcode.tinypokedex.data.mapper

import com.infinitumcode.tinypokedex.data.entity.local.PokemonDb
import com.infinitumcode.tinypokedex.domain.entity.Pokemon
import javax.inject.Inject

class PokemonDbToDomain @Inject constructor(): Mapper<PokemonDb, Pokemon> {
    override fun map(from: PokemonDb): Pokemon {
        return Pokemon(name = from.name, url = from.url)
    }
}