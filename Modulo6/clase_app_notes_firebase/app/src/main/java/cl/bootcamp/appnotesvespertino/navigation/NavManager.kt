package cl.bootcamp.appnotesvespertino.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.appnotesvespertino.view.login.BlankView
import cl.bootcamp.appnotesvespertino.view.login.TabsView
import cl.bootcamp.appnotesvespertino.view.notes.HomeView
import cl.bootcamp.appnotesvespertino.viewModel.LoginViewModel
import cl.bootcamp.appnotesvespertino.viewModel.NotesViewModel

@Composable
fun NavManager(loginViewModel: LoginViewModel, notesViewModel: NotesViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Blank") {
        composable("Blank") {
            BlankView(navController)
        }
        composable("Login") {
            TabsView(navController, loginViewModel)
        }
        composable("Home") {
            HomeView(navController, notesViewModel)
        }
    }
}