package ru.arefyev.rickandmorty.presentation.character_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import ru.arefyev.rickandmorty.domain.model.Character


@Composable
fun CharacterCardListItem(
    character: Character,
    onItemClick: (Character) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clickable { onItemClick(character) }
            .padding(10.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 12.dp,

    ) {
        CharacterAvatar(character = character)
//        Text(
////            text = "# ${character.id} ${character.name} (${character.species})",
//            text = character.name,
//            style = MaterialTheme.typography.body1,
//            overflow = TextOverflow.Ellipsis
//        )
    }
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable { onItemClick(character) }
//            .padding(10.dp),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        CoilImage(character = character)
//        Text(
////            text = "# ${character.id} ${character.name} (${character.species})",
//            text = character.name,
//            style = MaterialTheme.typography.body1,
//            overflow = TextOverflow.Ellipsis
//        )
//        Text(
//            text = "- ${character.status} -",
//            color = if (character.status == "Alive") Color.Green else Color.Red,
//            style = MaterialTheme.typography.body2,
//            fontStyle = FontStyle.Italic,
//            textAlign = TextAlign.End,
//            modifier = Modifier.align(CenterVertically)
//        )
//
//    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterAvatar(
    character: Character
) {
    val shape = RoundedCornerShape(12.dp)
    Box(
        modifier = Modifier
            .clip(shape)
            .height(120.dp)
            .width(120.dp)
//            .fillMaxSize()
    ) {
        val painter = rememberImagePainter(
            data = character.image,
            builder = {
                crossfade(1000)
            }
        )
        val painterState = painter.state
        Image(
            modifier = Modifier
                .fillMaxSize()
                .size(150.dp),
            painter = painter,
            contentDescription = "Avatar"
        )
        if (painterState is ImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
}
