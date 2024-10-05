package cl.bootcamp.onboardingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.onboardingapp.dataStore.StoreBoarding
import cl.bootcamp.onboardingapp.onBoardings.MainOnBoarding
import cl.bootcamp.onboardingapp.view.HomeView
import cl.bootcamp.onboardingapp.view.SplashScreen

@Composable
fun NavManager(modifier: Modifier) {
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBoarding.collectAsState(initial = true)

    val navController = rememberNavController()
    NavHost(navController, startDestination = if (store.value) "Home" else "Splash") {
        composable("OnBoarding") {
            MainOnBoarding(navController, dataStore)
        }
        composable("Home") {
            HomeView()
        }
        composable("Splash") {
            SplashScreen(navController, store.value)
        }
    }
}