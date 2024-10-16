package cl.bootcamp.claseroom.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.claseroom.view.AddView
import cl.bootcamp.claseroom.view.EditView
import cl.bootcamp.claseroom.view.HomeView
import cl.bootcamp.claseroom.viewModel.CronometroViewModel
import cl.bootcamp.claseroom.viewModel.CronosViewModel

@Composable
fun NavManager(
    modifier: Modifier,
    cronosViewModel: CronosViewModel,
    cronometroViewModel: CronometroViewModel
) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController, cronosViewModel)
        }
        composable("AddView") {
            AddView(navController, cronosViewModel, cronometroViewModel)
        }
        composable("EditView/{id}", arguments = listOf(
            navArgument("id") { type = NavType.LongType }
        )) {
            val id = it.arguments?.getLong("id") ?: 0
            EditView(navController, cronosViewModel, cronometroViewModel, id)
        }
    }
}