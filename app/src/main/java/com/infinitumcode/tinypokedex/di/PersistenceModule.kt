package com.infinitumcode.tinypokedex.di

import android.app.Application
import androidx.room.Room
import com.infinitumcode.tinypokedex.data.network.PokemonService
import com.infinitumcode.tinypokedex.data.persistence.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun providePokemonDatabase(
        application: Application
    ): PokemonDatabase {
        return PokemonDatabase.getInstance(application)
    }

}