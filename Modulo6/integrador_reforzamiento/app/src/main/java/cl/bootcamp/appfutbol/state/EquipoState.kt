package cl.bootcamp.appfutbol.state

data class EquipoState(
    val nombre: String = "",
    val logo: String = "",
    val estadio: String = "",
    val ciudad: String = "",
    val titulosNacionales: Int = 0,
    val fundacion: Int = 0,
    val titulosInternacionales: Int = 0,
    val directorTecnico: String = "",
    val colores: List<String> = listOf(),
    val entradas: Boolean = false
)
