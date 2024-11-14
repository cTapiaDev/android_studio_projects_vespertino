package cl.bootcamp.appheroes.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(superhero: Superhero)

    @Query("SELECT * FROM superheroe")
    fun getAllHeroes(): Flow<List<Superhero>>
}