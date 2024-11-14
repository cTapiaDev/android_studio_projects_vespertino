package cl.bootcamp.appheroes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "superheroe")
data class Superhero(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "primeraAparicion") val primeraAparicion: String,
    @ColumnInfo(name = "imagen") val imagen: String
)
