package cl.bootcamp.appfutbol.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EquipoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(equipo: Equipo)

    @Query("SELECT * FROM equipo ORDER BY id")
    fun getAll(): Flow<List<Equipo>>

}