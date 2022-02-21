package com.gzslt.boardgame.main.ui.boardgamelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gzslt.boardgame.api.util.ConnectionCheckUtil
import com.gzslt.boardgame.main.model.BoardGameListUiState
import com.gzslt.boardgame.main.model.BoardGameUiModel
import com.gzslt.boardgame.service.NetworkService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import logcat.logcat
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class BoardGameListViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    private val _uiState = MutableStateFlow<BoardGameListUiState>(BoardGameListUiState.Loading)
    val uiState: StateFlow<BoardGameListUiState> get() = _uiState

    val boardGameListFlow: Flow<List<BoardGameUiModel>> =
        // TODO get from db
        flow {
            emit(mockBoardGameList)
        }

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
                // TODO fetch from api
            } catch (exception: Exception) {
                logcat(message = { exception.message ?: "Exception has no message" })
                _uiState.value = BoardGameListUiState.Error
            }
        }
    }

    fun addItemToFavorites(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            // TODO
            _uiState.value = BoardGameListUiState.Loading
            delay(2000)
            _uiState.value = BoardGameListUiState.Success
        }
    }

    private val mockBoardGameList = listOf(
        BoardGameUiModel(
            id = "e61feb10-fae0-45a9-9c79-4133f4121602",
            name = "Crown of Emara",
            imageResource = "https://uploads-ssl.webflow.com/61980fb98326045a5690d1df/61dbfe6da3d9865d2eb4510b_crown_of_emara.jpg",
            true,
        ),
        BoardGameUiModel(
            id = "6a166dcf-988a-4efe-bafc-dba3b319c009",
            name = "Mars",
            imageResource = "https://uploads-ssl.webflow.com/61980fb98326045a5690d1df/61dc0037cb8a6f735ee95a96_mars.jpg",
            false,
        ),
    )
}
