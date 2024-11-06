package cl.bootcamp.integradorwallet.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM user ORDER BY id")
    fun getAll(): Flow<List<User>>

}