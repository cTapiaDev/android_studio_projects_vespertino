package cl.bootcamp.appheroes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.appheroes.view.DetailsView
import cl.bootcamp.appheroes.view.HomeView
import cl.bootcamp.appheroes.viewModel.HeroeViewModel

@Composable
fun NavManager(heroeViewModel: HeroeViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(heroeViewModel, navController)
        }
        composable("Details/{id}", arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )) {
            val id = it.arguments?.getInt("id") ?: 0
            DetailsView(heroeViewModel, navController, id)
        }
    }
}