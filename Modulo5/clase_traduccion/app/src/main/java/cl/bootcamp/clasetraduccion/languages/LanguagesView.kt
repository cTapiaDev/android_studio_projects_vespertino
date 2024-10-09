package cl.bootcamp.clasetraduccion.languages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun LanguagesView() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = LanguagesStore(context)

    val indexLang by dataStore.getIndexLang.collectAsState(initial = 0)

    val items = listOf("English", "Spanish")
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableIntStateOf(0) }

    val languages = getStrings()
    var currentLanguages by remember { mutableStateOf(languages[selectedIndex]) }

    LaunchedEffect(indexLang) {
        currentLanguages = languages[indexLang]
        selectedIndex = indexLang
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = items[selectedIndex])
            IconButton(
                onClick = { expanded = true }
            ) { Icon(Icons.Default.ArrowDropDown, "") }
            DropdownMenu(
                expanded,
                onDismissRequest = { expanded = false }
            ) {
                items.forEachIndexed { index, item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedIndex = index
                            currentLanguages = languages[index]
                            scope.launch {
                                dataStore.saveIndexLang(index)
                            }
                            expanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        Text(text = currentLanguages["title"].toString(), fontWeight = FontWeight.Bold)
        Text(text = currentLanguages["subtitle"].toString())
    }
}