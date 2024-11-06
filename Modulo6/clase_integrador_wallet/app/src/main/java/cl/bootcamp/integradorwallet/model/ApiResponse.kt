package cl.bootcamp.integradorwallet.model

data class ApiResponse(
    val resultados: ArrayList<UserWallet>
)

data class UserWallet(
    val id: Int,
    val nombre: String,
    val pais: String,
    val imagenLink: String,
    val cuenta: String,
    val saldo: Double,
    val depositos: Boolean
)