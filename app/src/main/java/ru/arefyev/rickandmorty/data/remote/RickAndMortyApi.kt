package ru.arefyev.rickandmorty.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.arefyev.rickandmorty.data.remote.dto.ApiCharactersResponse
import ru.arefyev.rickandmorty.data.remote.dto.Result

interface RickAndMortyApi {

    // https://rickandmortyapi.com/api/character?page=1
    @GET("/api/character")
    suspend fun getCharacters(@Query("page") page: Int): Response<ApiCharactersResponse<Result>>
}
