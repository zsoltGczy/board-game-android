package com.gzslt.boardgame.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gzslt.boardgame.database.model.BoardGameDataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface BoardGameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBoardGameList(boardGameList: List<BoardGameDataModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBoardGame(boardGame: BoardGameDataModel)

    @Query("SELECT * FROM Board_games ORDER BY isFavorite = 0, name ASC")
    fun getBoardGameList(): Flow<List<BoardGameDataModel>>

    @Query("Select * FROM Board_games WHERE id = :id")
    suspend fun getBoardGame(id: String): BoardGameDataModel
}
