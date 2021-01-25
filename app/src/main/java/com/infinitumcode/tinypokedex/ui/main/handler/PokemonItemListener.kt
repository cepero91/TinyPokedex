package com.infinitumcode.tinypokedex.ui.main.handler

import com.infinitumcode.tinypokedex.domain.entity.Pokemon

interface PokemonItemListener {
    fun onPokemonClick(item: Pokemon)
}
