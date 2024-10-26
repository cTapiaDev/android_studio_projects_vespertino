package cl.bootcamp.apprandomuser.datasource

import cl.bootcamp.apprandomuser.model.ApiResponse
import cl.bootcamp.apprandomuser.util.Constants.Companion.ENDPOINT_LOCATION
import cl.bootcamp.apprandomuser.util.Constants.Companion.ENDPOINT_NAME
import cl.bootcamp.apprandomuser.util.Constants.Companion.ENDPOINT_PICTURE
import retrofit2.http.GET

interface RestDataSource {

    @GET(ENDPOINT_NAME)
    suspend fun getUserName(): ApiResponse

    @GET(ENDPOINT_LOCATION)
    suspend fun getUserLocation(): ApiResponse

    @GET(ENDPOINT_PICTURE)
    suspend fun getUserPicture(): ApiResponse
}