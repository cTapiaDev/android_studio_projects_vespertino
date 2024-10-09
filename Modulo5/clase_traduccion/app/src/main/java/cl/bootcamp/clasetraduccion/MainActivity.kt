package cl.bootcamp.clasetraduccion

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.clasetraduccion.languages.LanguagesView
import cl.bootcamp.clasetraduccion.translator.TranslateView
import cl.bootcamp.clasetraduccion.translator.TranslateViewModel
import cl.bootcamp.clasetraduccion.ui.theme.ClaseTraduccionTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: TranslateViewModel by viewModels()
        setContent {
            ClaseTraduccionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    //MyView()
                    //LanguagesView()
                    TranslateView(viewModel)
                }
            }
        }
    }
}

@Composable
fun MyView() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.title), fontWeight = FontWeight.Bold)
        Text(text = stringResource(R.string.subtitle))
    }
}