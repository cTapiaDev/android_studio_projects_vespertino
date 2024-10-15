package cl.bootcamp.claseroom.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.bootcamp.claseroom.model.Cronos
import cl.bootcamp.claseroom.repository.CronosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CronosViewModel @Inject constructor(private val repository: CronosRepository): ViewModel() {

    private val _cronosList = MutableStateFlow<List<Cronos>>(emptyList())
    val cronoList = _cronosList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCronos().collect { item ->
                if (item.isNullOrEmpty()) {
                    _cronosList.value = emptyList()
                } else {
                    _cronosList.value = item
                }
            }
        }
    }

    fun addCrono(crono: Cronos) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCrono(crono)
        }
    }

    fun updateCrono(crono: Cronos) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCrono(crono)
        }
    }

    fun deleteCrono(crono: Cronos) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCrono(crono)
        }
    }

}