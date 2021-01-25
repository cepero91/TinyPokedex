package com.infinitumcode.tinypokedex.data.mapper

import com.infinitumcode.tinypokedex.data.entity.local.PokemonDb
import com.infinitumcode.tinypokedex.data.entity.remote.PokemonDto
import javax.inject.Inject

class PokemonDtoToDb @Inject constructor(): Mapper<PokemonDto, PokemonDb> {
    override fun map(from: PokemonDto): PokemonDb {
        return PokemonDb(name = from.name, url = from.url)
    }
}