package cl.bootcamp.appfutbol.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import cl.bootcamp.appfutbol.components.CardEquipo
import cl.bootcamp.appfutbol.viewModel.FutbolViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: FutbolViewModel, navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "App Futbol") }
            )
        }
    ) { innerPadding ->
        val equipos by viewModel.equipos.collectAsState(listOf())

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            items(equipos) { item ->
                CardEquipo(
                    item.nombre,
                    item.logo
                ) {
                    navController.navigate("DetailView/${item.id}")
                }
            }
        }
    }
}