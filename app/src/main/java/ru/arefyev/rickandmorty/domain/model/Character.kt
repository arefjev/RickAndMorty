package ru.arefyev.rickandmorty.domain.model


data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val gender: String,
    val species: String,
    val type: String,
    val url: String,
    val image: String
)
