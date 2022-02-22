package com.gzslt.boardgame.data

import com.gzslt.boardgame.database.model.BoardGameDataModel
import kotlinx.coroutines.flow.Flow

interface BoardGameRepository {

    val boardGameListStream: Flow<List<BoardGameDataModel>>

    suspend fun fetchBoardGameList()

    suspend fun updateBoardGame(id: String, isFavorite: Boolean)
}
