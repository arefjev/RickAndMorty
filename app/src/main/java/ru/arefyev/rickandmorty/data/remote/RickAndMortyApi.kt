package ru.arefyev.rickandmorty.data.remote

import retrofit2.http.GET

interface RickAndMortyApi {

    // https://rickandmortyapi.com/api/character?page=1
    @GET("/api/character")
    suspend fun getCharacters()
}
