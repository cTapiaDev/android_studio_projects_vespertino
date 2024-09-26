package cl.bootcamp.clasenavegacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.clasenavegacion.view.DetailsView
import cl.bootcamp.clasenavegacion.view.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController)
        }
        composable("Details/{id}/?{nombre}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("nombre") { type = NavType.StringType }
        )) {
            val id = it.arguments?.getInt("id") ?: 0
            val nombre = it.arguments?.getString("nombre") ?: ""
            DetailsView(navController, id, nombre)
        }
    }
}