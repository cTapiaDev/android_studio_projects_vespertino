package cl.bootcamp.appheroes

import android.arch.core.executor.testing.InstantTaskExecutorRule
import cl.bootcamp.appheroes.datasource.RestDataSource
import cl.bootcamp.appheroes.model.HeroeDao
import cl.bootcamp.appheroes.model.Superhero
import cl.bootcamp.appheroes.repository.HeroesRepositoryImp
import cl.bootcamp.appheroes.util.Constants.Companion.ENDPOINT
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.StandardCharsets

private val heroe1 = Superhero(1, "nombre", "aparicion", "http://...")
private val heroe2 = Superhero(2, "nombre", "aparicion", "http://...")
private val heroe3 = Superhero(3, "nombre", "aparicion", "http://...")
private val heroe4 = Superhero(4, "nombre", "aparicion", "http://...")
private val heroe5 = Superhero(5, "nombre", "aparicion", "http://...")
private val heroe6 = Superhero(6, "nombre", "aparicion", "http://...")
private val heroe7 = Superhero(7, "nombre", "aparicion", "http://...")
private val heroe8 = Superhero(8, "nombre", "aparicion", "http://...")
private val heroe9 = Superhero(9, "nombre", "aparicion", "http://...")
private val heroe10 = Superhero(10, "nombre", "aparicion", "http://...")
private val heroe11 = Superhero(11, "nombre", "aparicion", "http://...")
private val heroe12 = Superhero(12, "nombre", "aparicion", "http://...")

class HeroeUnitTest {

    private val mockWebServer = MockWebServer().apply {
        url("/")
        dispatcher = myDispatcher
    }

    private val restDataSource = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RestDataSource::class.java)

    private val newRepository = HeroesRepositoryImp(restDataSource, MockHeroeDao())

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Verificar si llegan correctamente los heroes`() = runBlocking {
        val heroes = newRepository.getAllSuperheroes().first()
        assertEquals(12, heroes.size)
    }

}

class MockHeroeDao: HeroeDao {
    private val heroes = MutableStateFlow<List<Superhero>>(listOf(
        heroe1, heroe2, heroe3, heroe4, heroe5, heroe6, heroe7, heroe8, heroe9, heroe10, heroe11, heroe12
    ))

    override suspend fun insert(superhero: Superhero) {
        heroes.value = heroes.value.toMutableList().apply { add(superhero) }
    }

    override fun getAllHeroes(): Flow<List<Superhero>> = heroes

}

val myDispatcher: Dispatcher = object : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            "/$ENDPOINT" -> MockResponse().apply { addResponse("api_heroes") }
            "/$ENDPOINT/1" -> MockResponse().apply { addResponse("api_heroe") }
            else -> MockResponse().setResponseCode(404)
        }
    }
}

fun MockResponse.addResponse(filePath: String): MockResponse {
    val inputStream = javaClass.classLoader?.getResourceAsStream(filePath)
    val source = inputStream?.source()?.buffer()
    source?.let {
        setResponseCode(200)
        setBody(it.readString(StandardCharsets.UTF_8))
    }
    return this
}