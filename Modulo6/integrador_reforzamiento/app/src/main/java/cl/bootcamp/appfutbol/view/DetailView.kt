package cl.bootcamp.appfutbol.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import cl.bootcamp.appfutbol.viewModel.FutbolViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(viewModel: FutbolViewModel, navController: NavController, id: Int) {

    LaunchedEffect(Unit) {
        viewModel.getEquipoById(id)
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.clean()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Vista Detalle", color = Color.White, fontWeight = FontWeight.Bold)},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA77840)
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() } ) {
                        Icon(
                            Icons.AutoMirrored.Default.ArrowBack,
                            "",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Text( text = viewModel.state.nombre )
            HorizontalDivider()
            Text( text = viewModel.state.estadio )
            HorizontalDivider()
            Text( text = viewModel.state.ciudad )
            HorizontalDivider()
            Text( text = viewModel.state.titulosNacionales.toString() )
            HorizontalDivider()
            Text( text = viewModel.state.fundacion.toString() )
            HorizontalDivider()
            Text( text = viewModel.state.titulosInternacionales.toString() )
            HorizontalDivider()
            Text( text = viewModel.state.directorTecnico)
            HorizontalDivider()
            Text( text = viewModel.state.colores.joinToString(", ") )
            HorizontalDivider()
            Text( text = viewModel.state.entradas.toString() )

        }
    }

}


