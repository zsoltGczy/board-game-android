package com.gzslt.boardgame.api.model

import retrofit2.http.GET

interface ApiClient {

    @GET("61980fb98326045a5690d1df/61dc0971fb94e004fa03b0af_board_games.txt")
    suspend fun fetchBoardGames(): List<BoardGameApiModel>
}
