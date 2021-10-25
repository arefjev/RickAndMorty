package ru.arefyev.rickandmorty.data.remote.dto


data class ApiCharactersResponse<T>(
    val info: InfoDto,
    val results: List<CharacterDto>
)