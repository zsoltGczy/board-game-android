package com.gzslt.boardgame.common.mapper

import com.gzslt.boardgame.api.model.BoardGameApiModel
import com.gzslt.boardgame.database.model.BoardGameDataModel

fun BoardGameApiModel.toDataModel() =
    BoardGameDataModel(
        id = id,
        name = name,
        imageResource = imageResource,
        isFavorite = false,
    )

fun List<BoardGameApiModel>.toDataModelList() =
    map {
        it.toDataModel()
    }
