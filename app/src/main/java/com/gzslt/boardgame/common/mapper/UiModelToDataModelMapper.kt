package com.gzslt.boardgame.common.mapper

import com.gzslt.boardgame.database.model.BoardGameDataModel
import com.gzslt.boardgame.main.model.BoardGameUiModel

fun BoardGameUiModel.toDataModel() =
    BoardGameDataModel(
        id = id,
        name = name,
        imageResource = imageResource,
        isFavorite = isFavorite,
    )

fun List<BoardGameUiModel>.toDataModelList() =
    map {
        it.toDataModel()
    }
