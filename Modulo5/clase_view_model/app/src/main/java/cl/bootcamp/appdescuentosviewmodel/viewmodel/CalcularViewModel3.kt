package cl.bootcamp.appdescuentosviewmodel.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.bootcamp.appdescuentosviewmodel.state.CalcularState

class CalcularViewModel3: ViewModel() {

    var state by mutableStateOf(CalcularState())
        private set



    fun onValue(value: String, text: String) {
        when (text) {
            "precio" -> state = state.copy(precio = value)
            "descuento" -> state = state.copy(descuento = value)
        }
    }

    fun calcular() {
        if (state.precio != "" && state.descuento != "") {
            state = state.copy(
                totalPrecio = calcularPrecio(state.precio.toDouble(), state.descuento.toDouble()),
                totalDescuento = calcularDescuento(state.precio.toDouble(), state.descuento.toDouble())
            )
        } else {
            state = state.copy(
                showAlert = true
            )
        }
    }

    private fun calcularDescuento(precio: Double, descuento: Double): Double {
        val result = precio * (1 - descuento / 100)
        return kotlin.math.round(result * 100) / 100.0
    }

    private fun calcularPrecio(precio: Double, descuento: Double): Double {
        val result = precio - calcularDescuento(precio, descuento)
        return kotlin.math.round(result * 100) / 100.0
    }

    fun limpiar() {
        state = state.copy(
            precio = "",
            descuento = "",
            totalPrecio = 0.0,
            totalDescuento = 0.0
        )
    }

    fun cancelarAlerta() {
        state = state.copy(
            showAlert = false
        )
    }


}