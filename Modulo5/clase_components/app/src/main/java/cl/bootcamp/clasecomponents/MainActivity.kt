package cl.bootcamp.clasecomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.clasecomponents.components.BotonDarkMode
import cl.bootcamp.clasecomponents.components.BotonDeshabilitado
import cl.bootcamp.clasecomponents.components.BotonFloating
import cl.bootcamp.clasecomponents.components.BotonIcono
import cl.bootcamp.clasecomponents.components.BotonNormal
import cl.bootcamp.clasecomponents.components.BotonOutline
import cl.bootcamp.clasecomponents.components.BotonSwitch
import cl.bootcamp.clasecomponents.components.BotonTexto
import cl.bootcamp.clasecomponents.components.Space
import cl.bootcamp.clasecomponents.ui.theme.ClaseComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val darkMode = remember { mutableStateOf(false) }
            ClaseComponentsTheme(
                darkTheme = darkMode.value
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    Content(innerPadding, darkMode)
                }
            }
        }
    }
}

@Composable
fun Content(paddingValues: PaddingValues, darkMode: MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BotonNormal()
        Space()
        BotonDeshabilitado()
        Space()
        BotonTexto()
        Space()
        BotonOutline()
        Space()
        BotonIcono()
        Space()
        BotonSwitch()
        Space()
        BotonFloating()
        Space()
        BotonDarkMode(darkMode)
    }
}
