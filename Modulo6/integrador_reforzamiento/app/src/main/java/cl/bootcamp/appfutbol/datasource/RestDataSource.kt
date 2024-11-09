package cl.bootcamp.appfutbol.datasource

import cl.bootcamp.appfutbol.model.DetalleEquipo
import cl.bootcamp.appfutbol.model.Equipos
import cl.bootcamp.appfutbol.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestDataSource {

    @GET(ENDPOINT)
    suspend fun getEquipos(): List<Equipos>

    @GET("$ENDPOINT/{id}")
    suspend fun getEquipoById(@Path(value = "id") id: Int): Response<DetalleEquipo>

}