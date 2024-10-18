package cl.bootcamp.appwishlist.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.appwishlist.R
import cl.bootcamp.appwishlist.components.AppBarView
import cl.bootcamp.appwishlist.components.Space
import cl.bootcamp.appwishlist.components.WishTextField
import cl.bootcamp.appwishlist.model.Wish
import cl.bootcamp.appwishlist.viewModel.WishViewModel
import kotlinx.coroutines.launch

@Composable
fun AddDetailView(
    id: Long,
    navController: NavController,
    wishViewModel: WishViewModel
) {

    val snackMessage = remember { mutableStateOf("")}
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()


    if (id != 0L) {
        val wish = wishViewModel.getAWishById(id).collectAsState(initial = Wish(0L, "" , ""))
        wishViewModel.wishTitleState = wish.value.title
        wishViewModel.wishDescriptionState = wish.value.description
    } else {
        wishViewModel.wishTitleState = ""
        wishViewModel.wishDescriptionState = ""
    }


    Scaffold(
        topBar = { AppBarView(
            if (id != 0L) stringResource(R.string.update_wish)
            else stringResource(R.string.add_wish)
        ) {navController.navigateUp()} },
        scaffoldState = scaffoldState
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
                        if (id != 0L) {
                            // UPDATE
                            wishViewModel.updateWish(
                                Wish(
                                    id = id,
                                    title = wishViewModel.wishTitleState.trim(),
                                    description = wishViewModel.wishDescriptionState.trim()
                                )
                            )
                            snackMessage.value = "Modificando deseo..."
                        } else {
                            // INSERT
                            wishViewModel.addWish(
                                Wish(
                                    title = wishViewModel.wishTitleState.trim(),
                                    description = wishViewModel.wishDescriptionState.trim()
                                )
                            )
                            snackMessage.value = "Creando deseo..."
                        }
                    } else {
                        snackMessage.value = "Debes ingresar un deseo"
                    }
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                        navController.navigateUp()
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