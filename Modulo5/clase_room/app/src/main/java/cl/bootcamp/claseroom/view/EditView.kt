package cl.bootcamp.claseroom.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.claseroom.R
import cl.bootcamp.claseroom.components.CircleButton
import cl.bootcamp.claseroom.components.MainIconButton
import cl.bootcamp.claseroom.components.MainTextField
import cl.bootcamp.claseroom.components.MainTitle
import cl.bootcamp.claseroom.components.formatTiempo
import cl.bootcamp.claseroom.model.Cronos
import cl.bootcamp.claseroom.viewModel.CronometroViewModel
import cl.bootcamp.claseroom.viewModel.CronosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditView(
    navController: NavController,
    cronosViewModel: CronosViewModel,
    cronometroViewModel: CronometroViewModel,
    id: Long
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { MainTitle(title = "EDIT APP") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.AutoMirrored.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentEditView(it, navController, cronosViewModel, cronometroViewModel, id)
    }
}

@Composable
fun ContentEditView(
    paddingValues: PaddingValues,
    navController: NavController,
    cronosViewModel: CronosViewModel,
    cronometroViewModel: CronometroViewModel,
    id: Long
) {
    val state = cronometroViewModel.state

    LaunchedEffect(state.cronoActivo) {
        cronometroViewModel.cronos()
    }

    LaunchedEffect(Unit) {
        cronometroViewModel.getCronoById(id)
    }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatTiempo(cronometroViewModel.tiempo),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            // Iniciar
            CircleButton(
                icon = painterResource(R.drawable.icon_play),
                enabled = !state.cronoActivo
            ) {
                cronometroViewModel.iniciar()
            }

            // Pausar
            CircleButton(
                icon = painterResource(R.drawable.icon_pause),
                enabled = state.cronoActivo
            ) {
                cronometroViewModel.pausar()
            }

        }
        MainTextField(
            value = state.title,
            onValueChange = { cronometroViewModel.onValue(it) },
            label = "Titulo"
        )

        Button(
            onClick = {
                cronosViewModel.updateCrono(
                    Cronos(
                        id = id,
                        title = state.title,
                        crono = cronometroViewModel.tiempo
                    )
                )
                cronometroViewModel.detener()
                navController.popBackStack()
            }
        ) {
            Text(text = "Editar")
        }
        DisposableEffect(Unit) {
            onDispose {
                cronometroViewModel.detener()
            }
        }
    }
}