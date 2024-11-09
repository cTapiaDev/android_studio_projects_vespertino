package cl.bootcamp.appfutbol.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.appfutbol.model.Equipo
import cl.bootcamp.appfutbol.model.EquipoDao

@Database(entities = [Equipo::class], version = 1)
abstract class DbDataSource: RoomDatabase() {
    abstract fun equipoDao(): EquipoDao
}