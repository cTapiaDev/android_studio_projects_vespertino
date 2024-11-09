package cl.bootcamp.appfutbol.repository

import cl.bootcamp.appfutbol.datasource.RestDataSource
import cl.bootcamp.appfutbol.model.DetalleEquipo
import cl.bootcamp.appfutbol.model.Equipo
import cl.bootcamp.appfutbol.model.EquipoDao
import cl.bootcamp.appfutbol.model.Equipos
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface FutbolRepository {
    suspend fun getEquipoById(id: Int): DetalleEquipo
    suspend fun getAllEquiposAPI(): ArrayList<Equipos>
    fun getAllEquiposRoom(): Flow<List<Equipo>>
}

class FutbolRepositoryImp @Inject constructor(
    private val dataSource: RestDataSource,
    private val equipoDao: EquipoDao
): FutbolRepository {
    override suspend fun getEquipoById(id: Int): DetalleEquipo {
        val data = dataSource.getEquipoById(id).body()!!
        val equipo = DetalleEquipo(
            id = data.id,
            nombre = data.nombre,
            logo = data.logo,
            estadio = data.estadio,
            ciudad = data.ciudad,
            titulosNacionales = data.titulosNacionales,
            fundacion = data.fundacion,
            titulosInternacionales = data.titulosInternacionales,
            directorTecnico = data.directorTecnico,
            colores = data.colores,
            entradas = data.entradas
        )
        return equipo
    }

    override suspend fun getAllEquiposAPI(): ArrayList<Equipos> {
        val data = dataSource.getEquipos()
        data.forEach {
            val equipo = Equipo(
                it.id,
                it.nombre,
                it.logo
            )
            equipoDao.insert(equipo)
        }
        return ArrayList(data)
    }

    override fun getAllEquiposRoom(): Flow<List<Equipo>> = equipoDao.getAll()

}