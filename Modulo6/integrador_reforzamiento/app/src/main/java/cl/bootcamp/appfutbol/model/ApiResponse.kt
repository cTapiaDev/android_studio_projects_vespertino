package cl.bootcamp.appfutbol.model

data class ApiResponse(
    val result: ArrayList<Equipos>
)

data class Equipos(
    val id: Int,
    val nombre: String,
    val logo: String
)

data class DetalleEquipo(
    val id: Int,
    val nombre: String,
    val logo: String,
    val estadio: String,
    val ciudad: String,
    val titulosNacionales: Int,
    val fundacion: Int,
    val titulosInternacionales: Int,
    val directorTecnico: String,
    val colores: List<String>,
    val entradas: Boolean
)
