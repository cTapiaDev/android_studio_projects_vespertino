package cl.bootcamp.appgames.model

data class SingleGameModel(
    val name : String,
    val description_raw: String,
    val metacritic: Int,
    val website: String,
    val background_image_additional: String
)
