package cl.bootcamp.appcorrutinas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel: ViewModel() {

    var result by mutableStateOf("")

    var isLoading by mutableStateOf(false)
        private set

    fun fetchData() {
        viewModelScope.launch {
            try {
                isLoading = true
                val newResult = withContext(Dispatchers.IO) {
                    delay(5000)
                    "Respuesta de la API"
                }
                result = newResult
            } catch (e: Exception) {
                print("error: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }
}