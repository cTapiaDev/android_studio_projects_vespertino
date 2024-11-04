package cl.bootcamp.claseapis.models

data class ApiGames(
    val id: Int,
    val name: String,
    val description: String,
    val metacritic: String,
    val metacritic_platforms: ArrayList<Platforms>
)

data class Platforms(
    val metascore: Int,
    val url: String,
    val platform: DetailsPlatform
)

data class DetailsPlatform(
    val platform: Int?,
    val name: String,
    val slug: String
)
