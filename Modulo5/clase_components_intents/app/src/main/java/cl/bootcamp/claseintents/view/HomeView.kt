package cl.bootcamp.claseintents.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.claseintents.components.BottomNav
import cl.bootcamp.claseintents.navigation.NavManager
import cl.bootcamp.claseintents.navigation.Routes

@Composable
fun HomeView() {
    val navController = rememberNavController()
    val navigationRoutes = listOf(
        Routes.PhoneView,
        Routes.SmsView,
        Routes.EmailView
    )

    Scaffold (
        bottomBar = {
            BottomNav(navController, navigationRoutes)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            NavManager(navController)
        }
    }
}