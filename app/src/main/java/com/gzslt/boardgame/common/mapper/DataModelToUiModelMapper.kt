package com.gzslt.boardgame.common.mapper

import com.gzslt.boardgame.database.model.BoardGameDataModel
import com.gzslt.boardgame.main.model.BoardGameUiModel

fun BoardGameDataModel.toUiModel() =
    BoardGameUiModel(
        id = id,
        name = name,
        imageResource = imageResource,
        isFavorite = isFavorite,
    )

fun List<BoardGameDataModel>.toUiModelList() =
    map {
        it.toUiModel()
    }
