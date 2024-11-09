package cl.bootcamp.appfutbol.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import cl.bootcamp.appfutbol.model.Equipo
import cl.bootcamp.appfutbol.repository.FutbolRepository
import cl.bootcamp.appfutbol.state.EquipoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FutbolViewModel @Inject constructor(
    private val repo: FutbolRepository
): ViewModel() {

    var state by mutableStateOf(EquipoState())
        private set

    val equipos: Flow<List<Equipo>> by lazy {
        repo.getAllEquiposRoom()
    }

    init {
        getAllAPI()
    }

    private fun getAllAPI() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllEquiposAPI()
        }
    }

    fun getEquipoById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repo.getEquipoById(id)
            state = state.copy(
                nombre = result.nombre,
                logo = result.logo,
                estadio = result.estadio,
                ciudad = result.ciudad,
                titulosNacionales = result.titulosNacionales,
                fundacion = result.fundacion,
                titulosInternacionales = result.titulosInternacionales,
                directorTecnico = result.directorTecnico,
                colores = result.colores,
                entradas = result.entradas
            )
        }
    }

    fun clean() {
        state = state.copy(
            nombre = "",
            logo = "",
            estadio = "",
            ciudad = "",
            titulosNacionales = 0,
            fundacion = 0,
            titulosInternacionales = 0,
            directorTecnico = "",
            colores = listOf(),
            entradas = false
        )
    }

}