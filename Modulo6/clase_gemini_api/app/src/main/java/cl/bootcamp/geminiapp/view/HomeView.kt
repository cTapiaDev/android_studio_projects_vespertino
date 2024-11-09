package cl.bootcamp.geminiapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cl.bootcamp.geminiapp.components.GlobeMessage
import cl.bootcamp.geminiapp.components.MessageInput
import cl.bootcamp.geminiapp.components.Title
import cl.bootcamp.geminiapp.ui.theme.backColor
import cl.bootcamp.geminiapp.viewModel.GeminiViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: GeminiViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Title() },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backColor
                ),
                actions = {
                    IconButton(onClick = { viewModel.deleteChat() }) {
                        Icon(Icons.Default.Delete, "Delete", tint = Color.White)
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .background(backColor)
        ) {
            ChatContent(modifier = Modifier.weight(1f), viewModel)
            MessageInput {
                viewModel.sendMessage(it)
            }
        }
    }
}

@Composable
fun ChatContent(
    modifier: Modifier,
    viewModel: GeminiViewModel
) {
    LaunchedEffect(Unit) {
        viewModel.loadChat()
    }
    LazyColumn(
        modifier = modifier,
        reverseLayout = true
    ) {
        items(viewModel.messageList.reversed()) {
            GlobeMessage(it)
        }
    }
}