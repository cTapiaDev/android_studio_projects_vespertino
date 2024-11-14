package cl.bootcamp.appheroes.datasource

import cl.bootcamp.appheroes.model.Heroe
import cl.bootcamp.appheroes.model.HeroeID
import cl.bootcamp.appheroes.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestDataSource {

    @GET(ENDPOINT)
    suspend fun getHeroes(): List<Heroe>

    @GET("$ENDPOINT/{id}")
    suspend fun getHeroeById(@Path(value = "id") id: Int): Response<HeroeID>

}