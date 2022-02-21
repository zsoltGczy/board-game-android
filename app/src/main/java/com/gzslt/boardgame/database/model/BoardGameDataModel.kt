package com.gzslt.boardgame.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Board_games")
data class BoardGameDataModel(
    @PrimaryKey
    val id: String,
    val name: String,
    val imageResource: String,
    val isFavorite: Boolean,
)
