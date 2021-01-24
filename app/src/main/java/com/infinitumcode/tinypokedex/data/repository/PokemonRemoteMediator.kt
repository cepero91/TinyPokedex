package com.infinitumcode.tinypokedex.data.repository

import androidx.paging.*
import com.infinitumcode.tinypokedex.data.datasource.local.LocalDataSource
import com.infinitumcode.tinypokedex.data.datasource.remote.RemoteDataSource
import com.infinitumcode.tinypokedex.data.entity.local.PokemonDb
import com.infinitumcode.tinypokedex.data.entity.local.RemoteKeyDb
import com.infinitumcode.tinypokedex.data.entity.remote.PokemonResponseDto
import com.infinitumcode.tinypokedex.data.mapper.PokemonDbToDomain
import com.infinitumcode.tinypokedex.data.wrapper.Result
import com.infinitumcode.tinypokedex.domain.entity.Pokemon
import com.infinitumcode.tinypokedex.domain.repository.PokemonRepository
import com.infinitumcode.tinypokedex.utils.Constants.PAGE_SIZE
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PokemonRemoteMediator @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val pokemonDbToDomain: PokemonDbToDomain
) : RemoteMediator<Int, PokemonDb>(), PokemonRepository {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonDb>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> null
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                if (remoteKeys?.nextKey == null) {
                    return MediatorResult.Success(
                        endOfPaginationReached = true
                    )
                }
                remoteKeys.nextKey
            }
            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
        }
        return try {
            val currentPage = page ?: 1
            when (val pokemonResponse = remoteDataSource.fetchPokemonList(currentPage)) {
                is Result.Success -> {
                    cachePokemonResponse(loadType, pokemonResponse.data)
                    MediatorResult.Success(endOfPaginationReached = pokemonResponse.data.results.isEmpty())
                }
                else -> MediatorResult.Error(Exception((pokemonResponse as Result.Error).errorMessage))
            }
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

    private fun cachePokemonResponse(loadType: LoadType, data: PokemonResponseDto) {

    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, PokemonDb>): RemoteKeyDb? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let {
                localDataSource.remoteKeyByName(it.name)
            }
    }

    override suspend fun fetchPokemonList(page: Int): Flow<PagingData<Pokemon>> {
        val pagingSourceFactory = { localDataSource.allPokemon() }

        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = this,
            pagingSourceFactory = pagingSourceFactory
        ).flow.map { pagingData ->
            pagingData.map {
                pokemonDbToDomain.map(it)
            }
        }
    }
}