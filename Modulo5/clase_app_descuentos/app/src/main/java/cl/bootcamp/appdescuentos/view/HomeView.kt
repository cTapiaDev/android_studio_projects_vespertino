package cl.bootcamp.appdescuentos.view

import androidx.compose.foundation.layout.Arrangement
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
import cl.bootcamp.appdescuentos.components.Alert
import cl.bootcamp.appdescuentos.components.ContentCards
import cl.bootcamp.appdescuentos.components.MainButton
import cl.bootcamp.appdescuentos.components.MainTextField
import cl.bootcamp.appdescuentos.components.Space

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
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
        ContentHomeView(it)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues) {

    var precio by remember { mutableStateOf("") }
    var descuento by remember { mutableStateOf("") }
    var totalDescuento by remember { mutableStateOf(0.0) }
    var totalPrecio by remember { mutableStateOf(0.0) }
    var showAlert by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {

        ContentCards(
            title1 = "Total", number1 = totalDescuento,
            title2 = "Descuento", number2 = totalPrecio
        )


        MainTextField(
            value = precio,
            onValueChange = { precio = it },
            label = "Precio"
        )
        Space()
        MainTextField(
            value = descuento,
            onValueChange = { descuento = it },
            label = "Descuento"
        )
        Space()
        MainButton("Generar descuento") {
            showAlert = true
        }

        if (showAlert) {
            Alert(
                title = "Alerta",
                msj = "Escribe el precio y el descuento",
                confirmText = "Aceptar",
                onConfirmClick = { showAlert = false }
            ) { }
        }
    }
}