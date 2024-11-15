package cl.bootcamp.appheroes.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import cl.bootcamp.appheroes.R
import cl.bootcamp.appheroes.components.CardHeroe
import cl.bootcamp.appheroes.components.TopBarComponent
import cl.bootcamp.appheroes.viewModel.HeroeViewModel

@Composable
fun HomeView(heroeViewModel: HeroeViewModel, navController: NavController) {

    Scaffold(
        topBar = {
            TopBarComponent(
                title = stringResource(R.string.app_name)
            ) { }
        }
    ) { innerPadding ->
        val heroes by heroeViewModel.superheroes.collectAsState(listOf())

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            items(heroes) { item ->
                CardHeroe(
                    item.nombre,
                    item.primeraAparicion,
                    item.imagen
                ) {
                    navController.navigate("Details/${item.id}")
                }
            }
        }
    }

}