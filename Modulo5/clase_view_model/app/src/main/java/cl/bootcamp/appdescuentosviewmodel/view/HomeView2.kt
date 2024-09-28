package cl.bootcamp.appdescuentosviewmodel.view

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cl.bootcamp.appdescuentosviewmodel.components.Alert
import cl.bootcamp.appdescuentosviewmodel.components.ContentCards
import cl.bootcamp.appdescuentosviewmodel.components.MainButton
import cl.bootcamp.appdescuentosviewmodel.components.MainTextField
import cl.bootcamp.appdescuentosviewmodel.components.Space
import cl.bootcamp.appdescuentosviewmodel.viewmodel.CalcularViewModel2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView2(viewModel2: CalcularViewModel2) {
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
        ContentHomeView2(it, viewModel2)
    }
}

@Composable
fun ContentHomeView2(
    paddingValues: PaddingValues,
    viewModel2: CalcularViewModel2
) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {

        ContentCards(
            title1 = "Descuento", number1 = viewModel2.totalPrecio,
            title2 = "Total", number2 = viewModel2.totalDescuento
        )
        MainTextField(
            value = viewModel2.precio,
            onValueChange = { viewModel2.onValue(it, "precio") },
            label = "Precio"
        )
        Space()
        MainTextField(
            value = viewModel2.descuento,
            onValueChange = { viewModel2.onValue(it, "descuento") },
            label = "Descuento %"
        )
        Space()
        MainButton("Generar descuento") {
            viewModel2.calcular()
        }
        Space()
        MainButton("Limpiar", color = MaterialTheme.colorScheme.error) {
            viewModel2.limpiar()
        }

        if (viewModel2.showAlert) {
            Alert(
                title = "Alerta",
                msj = "Escribe el precio y el descuento",
                confirmText = "Aceptar",
                onConfirmClick = { viewModel2.cancelarAlerta() }
            ) { }
        }
    }
}