package cl.bootcamp.integradorwallet.datasource

import cl.bootcamp.integradorwallet.model.UserWallet
import cl.bootcamp.integradorwallet.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestDataSource {

    @GET(ENDPOINT)
    suspend fun getUsers(): List<UserWallet>

    @GET("$ENDPOINT/{id}")
    suspend fun getUserById(@Path(value = "id") id: Int): Response<UserWallet>

}