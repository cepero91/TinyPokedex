package com.infinitumcode.tinypokedex.ui.main.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.infinitumcode.tinypokedex.domain.entity.Pokemon
import com.infinitumcode.tinypokedex.ui.main.handler.PokemonItemListener
import com.infinitumcode.tinypokedex.ui.main.viewholder.PokemonViewHolder

class PokemonListAdapter(private val listener: PokemonItemListener) :
    PagingDataAdapter<Pokemon, PokemonViewHolder>(HIT_ITEM_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val hitItem = getItem(position)
        hitItem?.let {
            holder.bind(it, listener)
        }
    }

    companion object {
        private val HIT_ITEM_COMPARATOR = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
                return (oldItem.name == newItem.name)
            }

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem == newItem
        }
    }
}
