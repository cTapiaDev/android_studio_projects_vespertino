package cl.bootcamp.claseroom.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.bootcamp.claseroom.repository.CronosRepository
import cl.bootcamp.claseroom.state.CronoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CronometroViewModel @Inject constructor(private val repository: CronosRepository): ViewModel() {

    var state by mutableStateOf(CronoState())
        private set

    var cronoJob by mutableStateOf<Job?>(null)
        private set

    var tiempo by mutableStateOf(0L)
        private set

    fun onValue(value: String) {
        state = state.copy(title = value)
    }

    fun iniciar() {
        state = state.copy(
            cronoActivo = true
        )
    }

    fun pausar() {
        state = state.copy(
            cronoActivo = false,
            showSaveButton = true
        )
    }

    fun detener() {
        cronoJob?.cancel()
        tiempo = 0
        state = state.copy(
            cronoActivo = false,
            showSaveButton = false,
            showTextField = false
        )
    }

    fun showTextField() {
        state = state.copy(
            showTextField = true
        )
    }

    fun cronos() {
        if (state.cronoActivo) {
            cronoJob?.cancel()
            cronoJob = viewModelScope.launch {
                while (true) {
                    delay(1000)
                    tiempo += 1000
                }
            }
        } else {
            cronoJob?.cancel()
        }
    }

    fun getCronoById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCronosById(id).collect { item ->
                if (item != null) {
                    tiempo = item.crono
                    state = state.copy(title = item.title)
                } else {
                    Log.d("Error", "El bojeto crono es nulo")
                }
            }
        }
    }

}