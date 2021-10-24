package ru.arefyev.rickandmorty.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ApiCharactersResponse(
    val info: Info,
    val results: List<Result>
)