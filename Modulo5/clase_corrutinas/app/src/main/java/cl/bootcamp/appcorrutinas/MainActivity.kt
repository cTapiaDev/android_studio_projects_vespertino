package cl.bootcamp.appcorrutinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cl.bootcamp.appcorrutinas.ui.theme.AppCorrutinasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: MainViewModel by viewModels()
        setContent {
            AppCorrutinasTheme {
                Content(viewModel)
            }
        }
    }
}

@Composable
fun Content(viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ButonColor()
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { viewModel.fetchData() }) {
            Text(text = "Llamar a la API")
        }
        Spacer(modifier = Modifier.height(10.dp))
        if (viewModel.isLoading) {
            CircularProgressIndicator()
        } else {
            Text(text = viewModel.result)
        }
    }
}

@Composable
fun ButonColor() {
    var color by remember { mutableStateOf(false) }

    Button(
        onClick = {color = !color},
        colors = ButtonDefaults.buttonColors(
            containerColor = if (color) Color.Blue else Color.Red
        )
    ) {
        Text(text = "Cambiar color")
    }
}