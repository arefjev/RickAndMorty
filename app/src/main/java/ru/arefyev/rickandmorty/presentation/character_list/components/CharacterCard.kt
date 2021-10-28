package ru.arefyev.rickandmorty.presentation.character_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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


//@Composable
//fun CharacterListItem(
//    character: Character,
//    onItemClick: (Character) -> Unit
//) {
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
//}


@Preview("CharacterAvatar")
@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterAvatar(
//    character: Character
//    @PreviewParameter(AvatarPreviewParameterProvider::class) avatar: Avatar
) {
//    val shape = RoundedCornerShape(10.dp)
//    Box(
//        modifier = Modifier
//            .height(140.dp)
//            .width(140.dp)
//            .clip(shape)
//    ) {
        val painter = rememberImagePainter(
            data = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            builder = {
                crossfade(100)

            }
        )
        val painterState = painter.state
        Image(
            modifier = Modifier.size(140.dp),
            painter = painter,
            contentDescription = "Avatar"
        )
//        contentScale = ContentScale.Crop,
//        modifier = Modifier.fillMaxWidth()
//        Image(
//            painter = rememberImagePainter(
//                data = "https://www.example.com/image.jpg",
//                onExecute = ExecuteCallback { _, _ -> true },
//                builder = {
//                    crossfade(true)
//                    placeholder(R.drawable.placeholder)
//                    transformations(CircleCropTransformation())
//                }
//            ),
//            contentDescription = null,
//            modifier = Modifier.size(128.dp)
//        )

        if (painterState is ImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
//}


//@Preview
//@Composable
//fun UserProfilePreview(
//    @PreviewParameter(UserPreviewParameterProvider::class) user: User
//) {
//    UserProfile(user)
//}


//class AvatarPreviewParameterProvider : PreviewParameterProvider<Avatar> {
//    override val values = sequenceOf(
//        Avatar("https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
//        Avatar("https://rickandmortyapi.com/api/character/avatar/16.jpeg"),
//        Avatar("https://rickandmortyapi.com/api/character/avatar/36.jpeg")
//    )
//}
//
//data class Avatar(val url: String)
