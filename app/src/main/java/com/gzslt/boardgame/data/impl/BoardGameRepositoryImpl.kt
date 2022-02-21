package com.gzslt.boardgame.data.impl

import com.gzslt.boardgame.api.model.ApiClient
import com.gzslt.boardgame.common.mapper.toDataModelList
import com.gzslt.boardgame.data.BoardGameRepository
import com.gzslt.boardgame.database.AppDatabase
import com.gzslt.boardgame.database.model.BoardGameDataModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BoardGameRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val appDatabase: AppDatabase,
) : BoardGameRepository {

    override val boardGameListStream: Flow<List<BoardGameDataModel>> =
        appDatabase.boardGameDao().getBoardGameList()

    override suspend fun fetchBoardGameList() {
        val response = apiClient.fetchBoardGames()

        appDatabase.boardGameDao().insertBoardGameList(
            response.toDataModelList()
        )
    }

    override suspend fun insertBoardGame(id: String) {
        val boardGameDataModel = getBoardGame(id)
        appDatabase.boardGameDao().insertBoardGame(
            BoardGameDataModel(
                id = boardGameDataModel.id,
                name = boardGameDataModel.name,
                imageResource = boardGameDataModel.imageResource,
                isFavorite = !boardGameDataModel.isFavorite
            )
        )
    }

    private suspend fun getBoardGame(id: String): BoardGameDataModel =
        appDatabase.boardGameDao().getBoardGame(id)
}
