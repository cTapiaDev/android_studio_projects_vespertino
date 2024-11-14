package cl.bootcamp.appheroes.model

data class HeroeState(
    val nombre: String = "",
    val nombreReal: String = "",
    val alias: List<String> = listOf(),
    val poderes: List<String> = listOf(),
    val primeraAparicion: String = "",
    val historia: String = "",
    val afiliaciones: List<String> = listOf(),
    val imagen: String = ""
)
