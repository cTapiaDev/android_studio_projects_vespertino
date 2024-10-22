package cl.bootcamp.appgames.data

import cl.bootcamp.appgames.model.GamesModel
import cl.bootcamp.appgames.model.SingleGameModel
import cl.bootcamp.appgames.util.Constants.Companion.API_KEY
import cl.bootcamp.appgames.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiGames {

    @GET(ENDPOINT + API_KEY)
    suspend fun getGames(): Response<GamesModel>

    @GET("$ENDPOINT/{id}$API_KEY")
    suspend fun getGameById(@Path(value = "id") id: Int): Response<SingleGameModel>

}