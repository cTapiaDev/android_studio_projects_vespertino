package cl.bootcamp.categoryapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cl.bootcamp.categoryapp.components.CategoryElements
import cl.bootcamp.categoryapp.viewModel.CategoryViewModel

@Composable
fun CategoryView(
    paddingValues: PaddingValues,
    viewModel: CategoryViewModel
) {
    val viewState by viewModel.categoriesState

    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            viewState.error != null -> {
                Text("ERROR")
            }
            else -> {
                CategoryElements(viewState.list)
            }
        }
    }

}