package cl.bootcamp.claseroom.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.claseroom.components.CronoCard
import cl.bootcamp.claseroom.components.FloatButton
import cl.bootcamp.claseroom.components.MainTitle
import cl.bootcamp.claseroom.components.formatTiempo
import cl.bootcamp.claseroom.viewModel.CronosViewModel
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    navController: NavController,
    cronosViewModel: CronosViewModel
) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { MainTitle(title = "CRONO APP") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatButton {
                navController.navigate("AddView")
            }
        }
    ){
        ContentHomeView(it, navController, cronosViewModel)
    }

}

@Composable
fun ContentHomeView(
    paddingValues: PaddingValues,
    navController: NavController,
    cronosViewModel: CronosViewModel
) {

    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        val cronoList by cronosViewModel.cronoList.collectAsState()

        LazyColumn {
            items(cronoList) { item ->
                val delete = SwipeAction(
                    icon = rememberVectorPainter(image = Icons.Default.Delete),
                    background = MaterialTheme.colorScheme.error,
                    onSwipe = { cronosViewModel.deleteCrono(item) }
                )
                SwipeableActionsBox(
                    startActions = listOf(delete),
                    //endActions = listOf(delete),
                    swipeThreshold = 150.dp
                ) {
                    CronoCard(item.title, formatTiempo(item.crono)) {
                        navController.navigate("EditView/${item.id}")
                    }
                }
            }
        }
    }

}