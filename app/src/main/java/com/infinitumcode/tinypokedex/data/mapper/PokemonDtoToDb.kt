package com.infinitumcode.tinypokedex.data.mapper

import com.infinitumcode.tinypokedex.data.entity.local.PokemonDb
import com.infinitumcode.tinypokedex.data.entity.remote.PokemonDto

class PokemonDtoToDb : Mapper<PokemonDto, PokemonDb> {
    override suspend fun map(from: PokemonDto): PokemonDb {
        return PokemonDb(name = from.name, url = from.url)
    }
}