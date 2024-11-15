package cl.bootcamp.appheroes.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.appheroes.R
import cl.bootcamp.appheroes.components.ImageHeroe
import cl.bootcamp.appheroes.components.TopBarComponent
import cl.bootcamp.appheroes.ui.theme.textColor
import cl.bootcamp.appheroes.viewModel.HeroeViewModel

@Composable
fun DetailsView(heroeViewModel: HeroeViewModel, navController: NavController, id: Int) {

    LaunchedEffect(Unit) {
        heroeViewModel.getHeroeById(id)
    }

    DisposableEffect(Unit) {
        onDispose {
            heroeViewModel.clean()
        }
    }

    val state = heroeViewModel.state


    Scaffold(
        topBar = {
            TopBarComponent(
                title = "${state.nombre} - ${state.nombreReal}",
                showButton = true
            ) {
                navController.popBackStack()
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState(0))
        ) {

            ImageHeroe(state.imagen)

            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider()

                Text(text = state.alias.joinToString(" - "), color = textColor)

                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider()

                Text(text = state.poderes.joinToString ( " - " ), color = textColor)

                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider()

                Text(text = state.afiliaciones.joinToString (" - "), color = textColor)

                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider()

                Text(text = state.historia, color = textColor)
                Spacer(modifier = Modifier.height(30.dp))
            }



        }
    }
}