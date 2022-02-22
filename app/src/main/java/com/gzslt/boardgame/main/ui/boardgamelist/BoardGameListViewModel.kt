package com.gzslt.boardgame.main.ui.boardgamelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gzslt.boardgame.common.mapper.toUiModelList
import com.gzslt.boardgame.data.BoardGameRepository
import com.gzslt.boardgame.main.model.BoardGameListUiState
import com.gzslt.boardgame.main.model.BoardGameUiModel
import com.gzslt.boardgame.service.NetworkService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import logcat.logcat
import javax.inject.Inject

@HiltViewModel
class BoardGameListViewModel @Inject constructor(
    private val repository: BoardGameRepository,
    private val networkService: NetworkService,
) : ViewModel() {

    private val _uiState = MutableStateFlow<BoardGameListUiState>(BoardGameListUiState.Loading)
    val uiState: StateFlow<BoardGameListUiState> get() = _uiState

    val boardGameListFlow: Flow<List<BoardGameUiModel>> =
        repository.boardGameListStream.map { it.toUiModelList() }

    init {
        fetchBoardGameList()
    }

    fun fetchBoardGameList() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = BoardGameListUiState.Loading
            if (!networkService.isConnected()) {
                _uiState.value = BoardGameListUiState.NetworkError
                return@launch
            }
            try {
                _uiState.value = BoardGameListUiState.Success
                repository.fetchBoardGameList()
            } catch (exception: Exception) {
                logcat(message = { exception.message ?: "Exception has no message" })
                _uiState.value = BoardGameListUiState.Error
            }
        }
    }

    fun rateBoardGameItem(id: String, isFavorite: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = BoardGameListUiState.Loading
            try {
                repository.updateBoardGame(id, isFavorite)
                // Imitating API call with delay
                delay(2000)
                _uiState.value = BoardGameListUiState.Success
            } catch (exception: Exception) {
                _uiState.value = BoardGameListUiState.Error
            }
        }
    }
}
