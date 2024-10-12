package cl.bootcamp.claseroom.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import cl.bootcamp.claseroom.model.Cronos
import kotlinx.coroutines.flow.Flow

@Dao // Data Access Observer
interface CronosDataBaseDao {

    // CRUD
    @Query("SELECT * FROM cronos")
    fun getCronos(): Flow<List<Cronos>>

    @Query("SELECT * FROM cronos WHERE id = :id")
    fun getCronosById(id: Long): Flow<Cronos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(crono: Cronos)

    @Update
    suspend fun update(crono: Cronos)

    @Delete
    suspend fun delete(crono: Cronos)
}