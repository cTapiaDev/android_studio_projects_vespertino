package cl.bootcamp.integradorwallet.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.integradorwallet.model.User
import cl.bootcamp.integradorwallet.model.UserDao

@Database(
    entities = [User::class],
    version = 1
)
abstract class DbDataSource: RoomDatabase() {
    abstract fun userDao(): UserDao
}