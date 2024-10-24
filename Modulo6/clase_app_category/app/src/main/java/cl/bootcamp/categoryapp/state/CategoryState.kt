package cl.bootcamp.categoryapp.state

import cl.bootcamp.categoryapp.model.Category

data class CategoryState(
    val loading: Boolean = true,
    val list: List<Category> = emptyList(),
    val error: String? = null
)
