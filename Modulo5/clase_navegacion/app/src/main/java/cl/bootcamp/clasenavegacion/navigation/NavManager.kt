package cl.bootcamp.clasenavegacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.clasenavegacion.view.DetailsView
import cl.bootcamp.clasenavegacion.view.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController)
        }
        composable("Details") {
            DetailsView()
        }
    }
}