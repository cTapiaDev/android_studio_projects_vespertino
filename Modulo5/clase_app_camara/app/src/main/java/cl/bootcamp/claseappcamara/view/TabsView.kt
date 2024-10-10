package cl.bootcamp.claseappcamara.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cl.bootcamp.claseappcamara.viewModel.ScannerViewModel

@Composable
fun TabsView(
    viewModel: ScannerViewModel,
    paddingValues: PaddingValues
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {  }

}