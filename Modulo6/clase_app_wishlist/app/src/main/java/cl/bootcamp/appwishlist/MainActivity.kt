package cl.bootcamp.appwishlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import cl.bootcamp.appwishlist.navigation.NavManager
import cl.bootcamp.appwishlist.ui.theme.AppWishListTheme
import cl.bootcamp.appwishlist.view.HomeView
import cl.bootcamp.appwishlist.viewModel.WishViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        val viewModel: WishViewModel by viewModels()
        setContent {
            AppWishListTheme {
                NavManager(viewModel)
            }
        }
    }
}