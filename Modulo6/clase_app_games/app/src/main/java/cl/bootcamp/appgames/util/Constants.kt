package cl.bootcamp.appgames.util

import cl.bootcamp.appgames.BuildConfig

class Constants {

    companion object {
        const val BASE_URL = "https://api.rawg.io/api/"
        const val ENDPOINT = "games"
        const val API_KEY = BuildConfig.api_key
    }
}
// https://api.rawg.io/api/games
// ?key=39ffd1232c55429f9fde114a3b8a4220