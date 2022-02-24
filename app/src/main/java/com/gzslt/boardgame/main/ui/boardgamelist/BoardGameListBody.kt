package com.gzslt.boardgame.main.ui.boardgamelist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gzslt.boardgame.main.model.BoardGameUiModel

@Composable
fun BoardGameListBody(
    boardGameList: List<BoardGameUiModel>,
    onItemClick: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(items = boardGameList) { model ->
            BoardGameListItem(model) { id, isFavorite ->
                onItemClick(id, isFavorite)
            }
        }
    }
}

@Composable
@Preview
private fun BoardGameListScreenPreview() {
    BoardGameListScreen()
}
