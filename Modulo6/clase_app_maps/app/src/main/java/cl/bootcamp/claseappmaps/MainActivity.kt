package cl.bootcamp.claseappmaps

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
import cl.bootcamp.claseappmaps.navigation.NavManager
import cl.bootcamp.claseappmaps.ui.theme.ClaseAppMapsTheme
import cl.bootcamp.claseappmaps.view.MapsView
import cl.bootcamp.claseappmaps.viewModel.SearchViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        val viewModel: SearchViewModel by viewModels()
        setContent {
            ClaseAppMapsTheme {
                NavManager(viewModel)
            }
        }
    }
}