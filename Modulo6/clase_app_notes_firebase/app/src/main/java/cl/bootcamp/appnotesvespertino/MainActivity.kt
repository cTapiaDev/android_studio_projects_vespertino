package cl.bootcamp.appnotesvespertino

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.appnotesvespertino.navigation.NavManager
import cl.bootcamp.appnotesvespertino.ui.theme.AppNotesVespertinoTheme
import cl.bootcamp.appnotesvespertino.viewModel.LoginViewModel
import cl.bootcamp.appnotesvespertino.viewModel.NotesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginViewModel: LoginViewModel by viewModels()
        val notesViewModel: NotesViewModel by viewModels()
        setContent {
            AppNotesVespertinoTheme {
                NavManager(loginViewModel, notesViewModel)
            }
        }
    }
}