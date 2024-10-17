package cl.bootcamp.appwishlist.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import cl.bootcamp.appwishlist.R
import cl.bootcamp.appwishlist.components.AppBarView
import cl.bootcamp.appwishlist.components.Space
import cl.bootcamp.appwishlist.components.WishTextField
import cl.bootcamp.appwishlist.navigation.Screen
import cl.bootcamp.appwishlist.viewModel.WishViewModel

@Composable
fun AddDetailView(
    id: Long,
    navController: NavController,
    wishViewModel: WishViewModel
) {
    Scaffold(
        topBar = { AppBarView(
            if (id != 0L) stringResource(R.string.update_wish)
            else stringResource(R.string.add_wish)
        ) {navController.navigateUp()} }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Space()
            WishTextField(
                label = "Title",
                value = wishViewModel.wishTitleState,
                onValueChange = { wishViewModel.onWishTitleChanged(it) }
            )
            Space()
            WishTextField(
                label = "Description",
                value = wishViewModel.wishDescriptionState,
                onValueChange = { wishViewModel.onWishDescriptionChanged(it) }
            )
            Space()
            Button(
                onClick = {
                    if (wishViewModel.wishTitleState.isNotEmpty() && wishViewModel.wishDescriptionState.isNotEmpty()) {
                        // Modificar base de datos -- Update
                    } else {
                        // Agregar nuevo item al Room
                    }
                }
            ) {
                Text(
                    text = if (id != 0L) stringResource(R.string.update_wish)
                    else stringResource(R.string.add_wish),
                    fontSize = 18.sp
                )
            }
        }
    }
}