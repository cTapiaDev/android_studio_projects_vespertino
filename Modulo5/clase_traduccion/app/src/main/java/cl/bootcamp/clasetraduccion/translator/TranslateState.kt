package cl.bootcamp.clasetraduccion.translator

data class TranslateState(
    val textToTranslate: String = "",
    val translateText: String = "",
    val isDownloading: Boolean = false
)
