package ru.arefyev.rickandmorty.data.remote.dto


data class ApiCharactersResponse<T>(
    val info: Info,
    val results: List<Character>
)