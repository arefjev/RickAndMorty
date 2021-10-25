package ru.arefyev.rickandmorty.data.repository

import retrofit2.Response
import ru.arefyev.rickandmorty.data.remote.RickAndMortyApi
import ru.arefyev.rickandmorty.data.remote.dto.ApiCharactersResponse
import ru.arefyev.rickandmorty.data.remote.dto.CharacterDto
import ru.arefyev.rickandmorty.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
) : CharacterRepository {

    override suspend fun getCharacters(page: Int): Response<ApiCharactersResponse<CharacterDto>> {
        return api.getCharacters(page)
    }
}