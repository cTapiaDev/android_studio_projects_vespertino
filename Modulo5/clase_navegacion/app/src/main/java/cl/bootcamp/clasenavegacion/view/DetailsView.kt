package cl.bootcamp.clasenavegacion.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cl.bootcamp.clasenavegacion.components.MainButton
import cl.bootcamp.clasenavegacion.components.Space
import cl.bootcamp.clasenavegacion.components.TitleBar
import cl.bootcamp.clasenavegacion.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsView() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("Details View") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red
                )
            )
        }
    ) {
        ContentDetailsView(it)
    }
}

@Composable
fun ContentDetailsView(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView("Details View")
        Space()
    }
}