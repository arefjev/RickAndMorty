package ru.arefyev.rickandmorty.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.arefyev.rickandmorty.common.Constants
import ru.arefyev.rickandmorty.data.remote.RickAndMortyApi
import ru.arefyev.rickandmorty.data.repository.CharacterRepositoryImpl
import ru.arefyev.rickandmorty.domain.repository.CharacterRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRickAndMortyApi(): RickAndMortyApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api: RickAndMortyApi): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }

}