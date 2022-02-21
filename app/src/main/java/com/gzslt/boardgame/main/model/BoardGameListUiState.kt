package com.gzslt.boardgame.main.model

sealed class BoardGameListUiState {
    object Loading : BoardGameListUiState()
    object Success : BoardGameListUiState()
    object NetworkError : BoardGameListUiState()
    object Error : BoardGameListUiState()
}
