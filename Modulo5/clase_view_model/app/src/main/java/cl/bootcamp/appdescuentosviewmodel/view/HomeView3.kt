package cl.bootcamp.appdescuentosviewmodel.view

import androidx.compose.runtime.Composable
import cl.bootcamp.appdescuentosviewmodel.viewmodel.CalcularViewModel3
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cl.bootcamp.appdescuentosviewmodel.components.Alert
import cl.bootcamp.appdescuentosviewmodel.components.ContentCards
import cl.bootcamp.appdescuentosviewmodel.components.MainButton
import cl.bootcamp.appdescuentosviewmodel.components.MainTextField
import cl.bootcamp.appdescuentosviewmodel.components.Space

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView3(viewModel3: CalcularViewModel3) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "App Descuentos", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        ContentHomeView3(it, viewModel3)
    }
}

@Composable
fun ContentHomeView3(
    paddingValues: PaddingValues,
    viewModel3: CalcularViewModel3
) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {
        val state = viewModel3.state

        ContentCards(
            title1 = "Descuento", number1 = state.totalPrecio,
            title2 = "Total", number2 = state.totalDescuento
        )
        MainTextField(
            value = state.precio,
            onValueChange = { viewModel3.onValue(it, "precio") },
            label = "Precio"
        )
        Space()
        MainTextField(
            value = state.descuento,
            onValueChange = { viewModel3.onValue(it, "descuento") },
            label = "Descuento %"
        )
        Space()
        MainButton("Generar descuento") {
            viewModel3.calcular()
        }
        Space()
        MainButton("Limpiar", color = MaterialTheme.colorScheme.error) {
            viewModel3.limpiar()
        }

        if (state.showAlert) {
            Alert(
                title = "Alerta",
                msj = "Escribe el precio y el descuento",
                confirmText = "Aceptar",
                onConfirmClick = { viewModel3.cancelarAlerta() }
            ) { }
        }
    }
}