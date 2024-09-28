package cl.bootcamp.appdescuentosviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.appdescuentosviewmodel.ui.theme.AppDescuentosViewModelTheme
import cl.bootcamp.appdescuentosviewmodel.view.HomeView
import cl.bootcamp.appdescuentosviewmodel.view.HomeView2
import cl.bootcamp.appdescuentosviewmodel.view.HomeView3
import cl.bootcamp.appdescuentosviewmodel.viewmodel.CalcularViewModel
import cl.bootcamp.appdescuentosviewmodel.viewmodel.CalcularViewModel2
import cl.bootcamp.appdescuentosviewmodel.viewmodel.CalcularViewModel3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //val viewModel: CalcularViewModel by viewModels()
        //val viewModel2: CalcularViewModel2 by viewModels()
        val viewModel3: CalcularViewModel3 by viewModels()
        setContent {
            AppDescuentosViewModelTheme {
                //HomeView(viewModel)
                //HomeView2(viewModel2)
                HomeView3(viewModel3)
            }
        }
    }
}