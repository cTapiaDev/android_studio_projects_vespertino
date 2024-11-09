package cl.bootcamp.geminiapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.geminiapp.model.ChatModel

@Database(entities = [ChatModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun chatDao(): ChatDao
}