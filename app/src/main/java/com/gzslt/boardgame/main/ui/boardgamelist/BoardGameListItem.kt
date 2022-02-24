package com.gzslt.boardgame.main.ui.boardgamelist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.gzslt.boardgame.main.model.BoardGameUiModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BoardGameListItem(boardGameUiModel: BoardGameUiModel, onItemClick: (String, Boolean) -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        onClick = { onItemClick(boardGameUiModel.id, boardGameUiModel.isFavorite) }
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row {
                BoardGameImage(boardGameUiModel.imageResource)
                Text(
                    text = boardGameUiModel.name,
                    style = typography.h6,
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                )
            }
            BoardGameIsFavoriteIcon(
                boardGameUiModel.isFavorite,
                Modifier
                    .align(Alignment.CenterVertically)
                    .padding(8.dp),
            )
        }
    }
}

@Composable
private fun BoardGameImage(imageResource: String) {
    Image(
        painter = rememberImagePainter(
            data = imageResource,
            builder = {
                crossfade(true)
            }
        ),
        contentDescription = "Image of board game",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@Composable
private fun BoardGameIsFavoriteIcon(isFavorite: Boolean, modifier: Modifier) {
    if (isFavorite) {
        Icon(Icons.Outlined.Star, contentDescription = "star", modifier = modifier)
    } else {
        Icon(Icons.Outlined.StarBorder, contentDescription = "star", modifier = modifier)
    }
}

@Composable
@Preview
private fun BoardGameListItemPreview() {
    BoardGameListItem(
        BoardGameUiModel(
            id = "e61feb10-fae0-45a9-9c79-4133f4121602",
            name = "Crown of Emara",
            imageResource = "https://uploads-ssl.webflow.com/61980fb98326045a5690d1df/61dbfe6da3d9865d2eb4510b_crown_of_emara.jpg",
            true,
        ),
    ) { _, _ ->
        // no-op
    }
}
