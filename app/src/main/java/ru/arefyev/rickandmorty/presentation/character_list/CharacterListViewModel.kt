package ru.arefyev.rickandmorty.presentation.character_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.arefyev.rickandmorty.common.Resource
import ru.arefyev.rickandmorty.domain.use_case.get_characters.GetCharactersUseCase
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _state = mutableStateOf<CharacterListState>(CharacterListState())
    val state: State<CharacterListState> = _state

    init {
        getCharacters()
    }

    private fun getCharacters() {
        getCharactersUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CharacterListState(characters = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CharacterListState(error = result.message ?: "Возникла непредвиденная ошибка!")
                }
                is Resource.Loading -> {
                    _state.value = CharacterListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}