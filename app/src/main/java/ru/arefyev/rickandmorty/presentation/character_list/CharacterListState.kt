package ru.arefyev.rickandmorty.presentation.character_list

import ru.arefyev.rickandmorty.domain.model.Character

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String = ""
)
