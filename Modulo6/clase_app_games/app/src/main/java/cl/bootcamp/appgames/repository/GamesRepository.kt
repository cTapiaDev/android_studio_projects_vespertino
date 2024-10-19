package cl.bootcamp.appgames.repository

import cl.bootcamp.appgames.data.ApiGames
import cl.bootcamp.appgames.model.GameList
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGames) {

    suspend fun getGames(): List<GameList>? {
        val response = apiGames.getGames()
        if (response.isSuccessful) {
            return response.body()?.results
        }
        return null
    }

}