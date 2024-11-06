package cl.bootcamp.integradorwallet.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import cl.bootcamp.integradorwallet.viewModel.WalletViewModel

@Composable
fun HomeView(viewModel: WalletViewModel, navController: NavController) {


    Text(text = "HomeView")
}