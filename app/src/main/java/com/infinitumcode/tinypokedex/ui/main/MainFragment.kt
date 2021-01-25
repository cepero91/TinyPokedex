package com.infinitumcode.tinypokedex.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.infinitumcode.tinypokedex.R
import com.infinitumcode.tinypokedex.databinding.FragmentMainBinding
import com.infinitumcode.tinypokedex.domain.entity.Pokemon
import com.infinitumcode.tinypokedex.ui.main.adapter.PokemonListAdapter
import com.infinitumcode.tinypokedex.ui.main.adapter.PokemonLoadStateAdapter
import com.infinitumcode.tinypokedex.ui.main.handler.PokemonItemListener
import com.wada811.databinding.dataBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main), SwipeRefreshLayout.OnRefreshListener,
    PokemonItemListener {

    private val binding: FragmentMainBinding by dataBinding()
    private val adapter: PokemonListAdapter = PokemonListAdapter(this)

    @VisibleForTesting
    val viewModel: MainViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
        obsPokemon()
    }

    override fun onPause() {
        adapter.removeLoadStateListener {}
        super.onPause()
    }

    private fun obsPokemon() {
        viewModel.allPokemon.observe(viewLifecycleOwner) {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    private fun initUI() {
        with(binding) {
            srlRefresh.setOnRefreshListener(this@MainFragment)
            initAdapterLoadingState()
            rvPokemon.adapter =
                adapter.withLoadStateFooter(footer = PokemonLoadStateAdapter())
            executePendingBindings()
        }
    }

    private fun initAdapterLoadingState() {
        adapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading) {
                binding.srlRefresh.isRefreshing = true
            } else {
                binding.srlRefresh.isRefreshing = false

                val errorState = when {
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                errorState?.let {
                    Toast.makeText(requireActivity(), it.error.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onRefresh() {
        adapter.refresh()
    }

    override fun onPokemonClick(item: Pokemon) {
        TODO("Not yet implemented")
    }

}