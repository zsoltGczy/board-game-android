package com.gzslt.boardgame.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gzslt.boardgame.BuildConfig
import com.gzslt.boardgame.database.model.BoardGameDataModel

@Database(
    entities = [
        BoardGameDataModel::class
    ],
    version = BuildConfig.DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun boardGameDao(): BoardGameDao
}
