package ru.arefyev.rickandmorty.data.remote.dto


import com.google.gson.annotations.SerializedName

data class InfoDto(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)