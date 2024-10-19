package cl.bootcamp.appgames.data

import cl.bootcamp.appgames.model.GamesModel
import cl.bootcamp.appgames.util.Constants.Companion.API_KEY
import cl.bootcamp.appgames.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiGames {

    @GET(ENDPOINT + API_KEY)
    suspend fun getGames(): Response<GamesModel>

}