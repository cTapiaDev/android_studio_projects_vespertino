package cl.bootcamp.integradorwallet.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.bootcamp.integradorwallet.model.User
import cl.bootcamp.integradorwallet.repository.WalletRepository
import cl.bootcamp.integradorwallet.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor(
    private val repo: WalletRepository
): ViewModel() {

    var state by mutableStateOf(UserState())
        private set

    val users: Flow<List<User>> by lazy {
        repo.getAllUserRoom()
    }

    init {
        getAllAPI()
    }

    private fun getAllAPI() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAllUserAPI()
        }
    }

    fun getUserById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repo.getUserById(id)
            state = state.copy(
                nombre = result.nombre,
                pais = result.pais,
                imagenLink = result.imagenLink,
                cuenta = result.cuenta,
                saldo = result.saldo,
                depositos = result.depositos
            )
        }
    }

    fun clean() {
        state = state.copy(
            nombre = "",
            pais = "",
            imagenLink = "",
            cuenta = "",
            saldo = 0.0,
            depositos = false
        )
    }

}