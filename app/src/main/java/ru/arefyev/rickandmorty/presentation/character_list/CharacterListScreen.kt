package ru.arefyev.rickandmorty.presentation.character_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.arefyev.rickandmorty.presentation.Screen
import ru.arefyev.rickandmorty.presentation.character_list.components.CharacterCardListItem
import ru.arefyev.rickandmorty.presentation.character_list.components.CharacterListItem

//@Preview
@Composable
fun CharacterListScreen(
    navController: NavController,
    viewModel: CharacterListViewModel = hiltViewModel() //,
    // @PreviewParameter(CharacterPreviewParameterProvider::class) character: Character
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.characters) { character ->
                CharacterCardListItem(
                    character = character,
                    onItemClick = {
                        navController.navigate(Screen.CharacterDetailScreen.route + "/${character.id}")
                    }
                )

//                CharacterListItem(
//                    character = character,
//                    onItemClick = {
//                        navController.navigate(Screen.CharacterDetailScreen.route + "/${character.id}")
//                    }
//                )
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
}

//class CharacterPreviewParameterProvider : PreviewParameterProvider<Character> {
//    override val values = sequenceOf(
//        Character(
//            1,
//            "Rick Sanchez",
//            "Alive",
//            "Male",
//            "Human",
//            "",
//            "https://rickandmortyapi.com/api/character/1",
//            "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
//        ),
//        Character(
//            6,
//            "Abadango Cluster Princess",
//            "Alive",
//            "Female",
//            "Alien",
//            "",
//            "https://rickandmortyapi.com/api/character/6",
//            "https://rickandmortyapi.com/api/character/avatar/6.jpeg"
//        ),
//        Character(
//            7,
//            "Abradolf Lincler",
//            "unknown",
//            "Male",
//            "Human",
//            "Genetic experiment",
//            "https://rickandmortyapi.com/api/character/7",
//            "https://rickandmortyapi.com/api/character/avatar/7.jpeg"
//        )
//    )
//}