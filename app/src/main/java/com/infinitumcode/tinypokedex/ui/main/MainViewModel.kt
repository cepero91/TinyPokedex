package com.infinitumcode.tinypokedex.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.infinitumcode.tinypokedex.domain.entity.Pokemon
import com.infinitumcode.tinypokedex.domain.usecase.PokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val pokemonListUseCase: PokemonListUseCase) :
    ViewModel() {

    val allPokemon: LiveData<PagingData<Pokemon>> by lazy {
        pokemonListUseCase.invoke().cachedIn(viewModelScope).asLiveData()
    }
}