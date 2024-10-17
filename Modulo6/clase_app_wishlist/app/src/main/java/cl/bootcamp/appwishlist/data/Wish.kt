package cl.bootcamp.appwishlist.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyWish {
    val wishList = listOf(
        Wish(title = "Google Watch 2", description = "Un reloj de android"),
        Wish(title = "Oculus Quest 2", description = "Un set VR para jugar"),
        Wish(title = "Alas de Sangre", description = "Un libro best seller"),
        Wish(title = "Play Station 5", description = "Consola de videojuegos")
    )
}
