package ru.arefyev.rickandmorty.presentation.character_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import ru.arefyev.rickandmorty.domain.model.Character

@Composable
fun CharacterListItem(
    character: Character,
    onItemClick: (Character) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(character) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "# ${character.id} ${character.name} (${character.species})",
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