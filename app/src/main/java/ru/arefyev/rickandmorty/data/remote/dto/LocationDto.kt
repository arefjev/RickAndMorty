package ru.arefyev.rickandmorty.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LocationDto(
    val name: String,
    val url: String
)