package com.infinitumcode.tinypokedex.ui.main.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.infinitumcode.tinypokedex.R
import com.infinitumcode.tinypokedex.databinding.ItemPokemonBinding
import com.infinitumcode.tinypokedex.domain.entity.Pokemon
import com.infinitumcode.tinypokedex.ui.main.handler.PokemonItemListener

class PokemonViewHolder(val binding: ItemPokemonBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: Pokemon, listener: PokemonItemListener?) {
        with(binding) {
            executePendingBindings()
        }
    }

    companion object {
        fun create(parent: ViewGroup): PokemonViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pokemon, parent, false)
            val binding = ItemPokemonBinding.bind(view)
            return PokemonViewHolder(binding)
        }
    }
}
