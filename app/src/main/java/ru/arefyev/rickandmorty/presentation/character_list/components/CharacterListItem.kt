package ru.arefyev.rickandmorty.presentation.character_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import ru.arefyev.rickandmorty.domain.model.Character

@Composable
fun CharacterListItem(
    character: Character,
    onItemClick: (Character) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(character) }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CoilImage(character = character)
        Text(
//            text = "# ${character.id} ${character.name} (${character.species})",
            text = character.name,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "- ${character.status} -",
            color = if (character.status == "Alive") Color.Green else Color.Red,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            modifier = Modifier.align(CenterVertically)
        )

    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CoilImage(character: Character) {
    Box(
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    ) {
        val painter = rememberImagePainter(
            data = character.image,
            builder = {
                crossfade(500)
            }
        )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "Avatar")
        if (painterState is ImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
}
