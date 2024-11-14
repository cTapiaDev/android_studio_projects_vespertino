package cl.bootcamp.appheroes.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.appheroes.model.HeroeDao
import cl.bootcamp.appheroes.model.Superhero

@Database(entities = [Superhero::class], version = 1)
abstract class DbDataSource: RoomDatabase() {
    abstract fun heroeDao(): HeroeDao
}