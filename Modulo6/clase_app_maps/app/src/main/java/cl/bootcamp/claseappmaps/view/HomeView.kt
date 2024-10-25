package cl.bootcamp.claseappmaps.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.claseappmaps.viewModel.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    navController: NavController,
    viewModel: SearchViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Search Place") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var search by remember { mutableStateOf("") }
            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                label = { Text(text = "Search") },
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            OutlinedButton(onClick = {viewModel.getLocation(search)}) {
                Text(text = "Search")
            }
            if (viewModel.show) {
                Text(text = "Latitude: ${viewModel.lat}")
                Text(text = "Longitude: ${viewModel.long}")
                Text(text = "Address: ${viewModel.address}")
                OutlinedButton(onClick = {
                    navController.navigate("MapSearchView/" +
                            "${viewModel.lat}/${viewModel.long}/${viewModel.address}")
                }) {
                    Text(text = "Send")
                }
            }
        }
    }
}