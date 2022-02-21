package com.gzslt.boardgame.main.ui.boardgamelist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gzslt.boardgame.main.model.BoardGameUiModel

@Composable
fun BoardGameListScreen(modifier: Modifier = Modifier) {

    LazyColumn(modifier) {
        // TODO
        items(items = mockBoardGameList) {
            // TODO Create boardGameItem
        }
    }
}

@Composable
@Preview
private fun BoardGameListScreenPreview() {
    BoardGameListScreen()
}

private val mockBoardGameList = listOf(
    BoardGameUiModel(
        id = "e61feb10-fae0-45a9-9c79-4133f4121602",
        name = "Crown of Emara",
        imageResource = "https://uploads-ssl.webflow.com/61980fb98326045a5690d1df/61dbfe6da3d9865d2eb4510b_crown_of_emara.jpg",
    ),
    BoardGameUiModel(
        id = "6a166dcf-988a-4efe-bafc-dba3b319c009",
        name = "Mars",
        imageResource = "https://uploads-ssl.webflow.com/61980fb98326045a5690d1df/61dc0037cb8a6f735ee95a96_mars.jpg",
    ),
)
