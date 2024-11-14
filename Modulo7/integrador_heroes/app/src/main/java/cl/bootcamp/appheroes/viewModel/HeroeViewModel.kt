package cl.bootcamp.appheroes.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.bootcamp.appheroes.model.HeroeState
import cl.bootcamp.appheroes.repository.HeroesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroeViewModel @Inject constructor(
    private val repo: HeroesRepository
): ViewModel() {

    var state by mutableStateOf(HeroeState())
        private set

    init {
        getAllAPI()
    }

    fun getAllAPI() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("HEROES API", repo.getAllHeroes().toString())
        }
    }

}