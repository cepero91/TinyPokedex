package com.infinitumcode.tinypokedex.ui.main.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.infinitumcode.tinypokedex.R
import com.infinitumcode.tinypokedex.databinding.ItemLoadStateBinding

class LoadStateViewHolder(
    private val binding: ItemLoadStateBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(loadState: LoadState) {
        binding.pbLoadState.isVisible = loadState is LoadState.Loading
    }

    companion object {
        fun create(parent: ViewGroup): LoadStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_load_state, parent, false)
            val binding = ItemLoadStateBinding.bind(view)
            return LoadStateViewHolder(binding)
        }
    }
}
