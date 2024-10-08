package cl.bootcamp.claseintents.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cl.bootcamp.claseintents.view.EmailView
import cl.bootcamp.claseintents.view.PhoneView
import cl.bootcamp.claseintents.view.SmsView

@Composable
fun NavManager(navHostController: NavHostController) {
    NavHost(navHostController, startDestination = Routes.PhoneView.route) {
        composable(Routes.PhoneView.route) {
            PhoneView()
        }
        composable(Routes.SmsView.route) {
            SmsView()
        }
        composable(Routes.EmailView.route) {
            EmailView()
        }
    }
}