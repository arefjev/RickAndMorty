package ru.arefyev.rickandmorty.data.remote.dto

import ru.arefyev.rickandmorty.domain.model.Character


data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDto,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterDto.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        gender = gender,
        species = species,
        type = type,
        url = url,
        image = image
    )
}
