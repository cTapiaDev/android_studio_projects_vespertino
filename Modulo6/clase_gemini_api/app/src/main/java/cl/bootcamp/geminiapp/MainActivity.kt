package cl.bootcamp.geminiapp

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
import cl.bootcamp.geminiapp.ui.theme.GeminiAppTheme
import cl.bootcamp.geminiapp.view.HomeView
import cl.bootcamp.geminiapp.viewModel.GeminiViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: GeminiViewModel by viewModels()
        setContent {
            GeminiAppTheme {
                HomeView(viewModel)
            }
        }
    }
}