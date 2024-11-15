package cl.bootcamp.appheroes.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.bootcamp.appheroes.model.HeroeState
import cl.bootcamp.appheroes.model.Superhero
import cl.bootcamp.appheroes.repository.HeroesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroeViewModel @Inject constructor(
    private val repo: HeroesRepository
): ViewModel() {

    var state by mutableStateOf(HeroeState())
        private set

    val superheroes: Flow<List<Superhero>> by lazy {
        repo.getAllSuperheroes()
    }

    init {
        getAllAPI()
    }

    private fun getAllAPI() {
        viewModelScope.launch(Dispatchers.IO) {
            // Log.d("HEROES API", repo.getAllHeroes().toString())
            repo.getAllHeroes()
        }
    }

    fun getHeroeById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val datos = repo.getHeroeById(id)
            state = state.copy(
                nombre = datos.nombre,
                nombreReal = datos.nombreReal,
                alias = datos.alias,
                poderes = datos.poderes,
                primeraAparicion = datos.primeraAparicion,
                historia = datos.historia,
                afiliaciones = datos.afiliaciones,
                imagen = datos.imagen
            )
        }
    }

    fun clean() {
        state = state.copy(
            nombre = "",
            nombreReal = "",
            alias = listOf(),
            poderes = listOf(),
            primeraAparicion = "",
            historia = "",
            afiliaciones = listOf(),
            imagen = ""
        )
    }

}