package cl.bootcamp.appheroes.model

data class ApiResponse(
    val data: ArrayList<Heroe>
)

data class Heroe(
    val id: Int,
    val nombre: String,
    val primeraAparicion: String,
    val imagen: String,
)

data class HeroeID(
    val id: Int,
    val nombre: String,
    val nombreReal: String,
    val alias: List<String>,
    val poderes: List<String>,
    val primeraAparicion: String,
    val historia: String,
    val afiliaciones: List<String>,
    val imagen: String
)
