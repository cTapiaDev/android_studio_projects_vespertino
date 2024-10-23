package cl.bootcamp.appgames.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.appgames.view.DetailView
import cl.bootcamp.appgames.view.HomeView
import cl.bootcamp.appgames.view.SearchGameView
import cl.bootcamp.appgames.viewModel.GamesViewModel

@Composable
fun NavManager(viewModel: GamesViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(viewModel, navController)
        }
        composable("Detail/{id}/?{name}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("name") { type = NavType.StringType }
        )) {
            val id = it.arguments?.getInt("id") ?: 0
            val name = it.arguments?.getString("name") ?: ""
            DetailView(viewModel, navController, id, name)
        }
        composable("SearchGameView") {
            SearchGameView(viewModel, navController)
        }
    }
}