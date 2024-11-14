package cl.bootcamp.appheroes.repository

import cl.bootcamp.appheroes.datasource.RestDataSource
import cl.bootcamp.appheroes.model.Heroe
import cl.bootcamp.appheroes.model.HeroeDao
import cl.bootcamp.appheroes.model.HeroeID
import cl.bootcamp.appheroes.model.Superhero
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface HeroesRepository {
    suspend fun getHeroeById(id: Int): HeroeID
    suspend fun getAllHeroes(): ArrayList<Heroe>
    fun getAllSuperheroes(): Flow<List<Superhero>>
}

class HeroesRepositoryImp @Inject constructor(
    private val dataSource: RestDataSource,
    private val heroeDao: HeroeDao
): HeroesRepository {
    override suspend fun getHeroeById(id: Int): HeroeID {
        val datos = dataSource.getHeroeById(id).body()!!
        val heroe = HeroeID(
            datos.id,
            datos.nombre,
            datos.nombreReal,
            datos.alias,
            datos.poderes,
            datos.primeraAparicion,
            datos.historia,
            datos.afiliaciones,
            datos.imagen
        )
        return heroe
    }

    override suspend fun getAllHeroes(): ArrayList<Heroe> {
        val datos = dataSource.getHeroes()
        datos.forEach {
            val heroe = Superhero(
                it.id,
                it.nombre,
                it.primeraAparicion,
                it.imagen
            )
            heroeDao.insert(heroe)
        }
        return ArrayList(datos)
    }

    override fun getAllSuperheroes(): Flow<List<Superhero>> = heroeDao.getAllHeroes()

}