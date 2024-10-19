package cl.bootcamp.appgames.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import cl.bootcamp.appgames.components.MainTopBar
import cl.bootcamp.appgames.viewModel.GamesViewModel

@Composable
fun DetailView(
    viewModel: GamesViewModel,
    navController: NavController,
    id: Int
) {
    Scaffold(
        topBar = {
            MainTopBar(title = "DETAIL VIEW", showBackButton = true, onClickBackButton = {navController.popBackStack()}) { }
        }
    ) {
        ContentDetailView(it, viewModel, navController)
    }
}

@Composable
fun ContentDetailView(
    paddingValues: PaddingValues,
    viewModel: GamesViewModel,
    navController: NavController
) {

}