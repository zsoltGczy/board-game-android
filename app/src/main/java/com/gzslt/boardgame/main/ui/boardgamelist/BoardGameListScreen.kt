package com.gzslt.boardgame.main.ui.boardgamelist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.gzslt.boardgame.main.model.BoardGameListUiState
import com.gzslt.boardgame.main.model.BoardGameUiModel

@Composable
fun BoardGameListScreen(
    viewModel: BoardGameListViewModel = hiltViewModel(),
) {

    val uiState: BoardGameListUiState by viewModel.uiState.collectAsState(initial = BoardGameListUiState.Loading)
    val boardGameList: List<BoardGameUiModel> by viewModel.boardGameListFlow.collectAsState(listOf())

    when (uiState) {
        BoardGameListUiState.Loading -> Loading()
        BoardGameListUiState.Success -> BoardGameListBody(
            boardGameList = boardGameList,
            onItemClick = { id, isFavorite ->
                viewModel.rateBoardGameItem(id, isFavorite)
            }
        )
        BoardGameListUiState.NetworkError -> ErrorBody(
            message = "No internet connection. Turn on wifi or mobile data."
        ) {
            viewModel.fetchBoardGameList()
        }
        BoardGameListUiState.Error -> ErrorBody(message = "Something went wrong") {
            viewModel.fetchBoardGameList()
        }
    }
}
