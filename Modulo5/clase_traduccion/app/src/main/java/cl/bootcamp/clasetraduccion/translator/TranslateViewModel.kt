package cl.bootcamp.clasetraduccion.translator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TranslateViewModel: ViewModel() {

    var state by mutableStateOf(TranslateState())
        private set

    fun onValue(text: String) {
        state = state.copy(textToTranslate = text)
    }

}