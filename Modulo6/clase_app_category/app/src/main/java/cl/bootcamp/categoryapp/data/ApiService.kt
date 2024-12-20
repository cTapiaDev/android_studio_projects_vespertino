package cl.bootcamp.categoryapp.data

import cl.bootcamp.categoryapp.model.CategoriesResponse
import cl.bootcamp.categoryapp.util.Constants.Companion.BASE_URL
import cl.bootcamp.categoryapp.util.Constants.Companion.ENDPOINT
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val categoryService = retrofit.create(ApiService::class.java)

interface ApiService {

    @GET(ENDPOINT)
    suspend fun getCategories(): CategoriesResponse

}