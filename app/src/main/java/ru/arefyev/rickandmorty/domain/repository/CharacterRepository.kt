package ru.arefyev.rickandmorty.domain.repository

import retrofit2.Response
import ru.arefyev.rickandmorty.data.remote.dto.ApiCharactersResponse
import ru.arefyev.rickandmorty.data.remote.dto.CharacterDto

interface CharacterRepository {

    suspend fun getCharacters(page: Int): Response<ApiCharactersResponse<List<CharacterDto>>>
}