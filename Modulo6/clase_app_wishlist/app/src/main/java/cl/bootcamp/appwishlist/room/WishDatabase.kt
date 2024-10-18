package cl.bootcamp.appwishlist.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.appwishlist.model.Wish

@Database(
    entities = [Wish::class],
    version = 1
)
abstract class WishDatabase: RoomDatabase() {
    abstract fun wishDao(): WishDao
}