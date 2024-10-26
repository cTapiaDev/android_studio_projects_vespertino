package cl.bootcamp.apprandomuser.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.apprandomuser.model.User
import cl.bootcamp.apprandomuser.model.UserDao

@Database(entities = [User::class], version = 1)
abstract class DbDataSource: RoomDatabase() {
    abstract fun userDao(): UserDao
}