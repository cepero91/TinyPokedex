package com.infinitumcode.tinypokedex.di

import com.infinitumcode.tinypokedex.data.datasource.local.LocalDataSource
import com.infinitumcode.tinypokedex.data.datasource.local.LocalDataSourceImpl
import com.infinitumcode.tinypokedex.data.datasource.remote.RemoteDataSource
import com.infinitumcode.tinypokedex.data.datasource.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}