package cl.bootcamp.clasetraduccion.translator

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import cl.bootcamp.clasetraduccion.R
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun TranslateView(
    viewModel: TranslateViewModel
) {
    val state = viewModel.state
    val context = LocalContext.current
    val languageOptions = viewModel.languageOptions
    val itemSelection = viewModel.itemSelection
    var indexSource by remember { mutableStateOf(0) }
    var indexTarget by remember { mutableStateOf(1) }
    var expandedSource by remember { mutableStateOf(false) }
    var expandedTarget by remember { mutableStateOf(false) }
    var selectedSourceLang by remember { mutableStateOf(languageOptions[0]) }
    var selectedTargetLang by remember { mutableStateOf(languageOptions[1]) }

    val itemsVoice = viewModel.itemsVoice
    var selectedTargetVoice by remember { mutableStateOf(itemsVoice[1]) }

    val permissionState = rememberPermissionState(permission = Manifest.permission.RECORD_AUDIO)

    SideEffect {
        permissionState.launchPermissionRequest()
    }

    val speechRecognizerLauncher = rememberLauncherForActivityResult(
        SpeechRecognizerContract()
    ) {
        viewModel.onValue(it.toString()
            .replace("[","")
            .replace("]","")
            .trimStart()
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            DropdownLang(
                itemSelection = itemSelection,
                selectedIndex = indexSource,
                expand = expandedSource,
                onClickExpanded = { expandedSource = true },
                onClickDismiss = { expandedSource = false },
                onClickItem = { index ->
                    indexSource = index
                    selectedSourceLang = languageOptions[index]
                    expandedSource = true
                }
            )

            Icon(
                Icons.AutoMirrored.Default.ArrowForward,
                "",
                modifier = Modifier
                    .padding(horizontal = 15.dp)
            )

            DropdownLang(
                itemSelection = itemSelection,
                selectedIndex = indexTarget,
                expand = expandedTarget,
                onClickExpanded = { expandedTarget = true },
                onClickDismiss = { expandedTarget = false },
                onClickItem = { index ->
                    indexTarget = index
                    selectedTargetLang = languageOptions[index]
                    selectedTargetVoice = itemsVoice[index]
                    expandedTarget = false
                }
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = state.textToTranslate,
            onValueChange = { viewModel.onValue(it) },
            label = { Text(text = "Escribe...") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    viewModel.onTranslate(
                        state.textToTranslate,
                        context,
                        selectedSourceLang,
                        selectedTargetLang
                    )
                }
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            MainIconButton(R.drawable.icon_mic) {
                if (permissionState.status.isGranted) {
                    speechRecognizerLauncher.launch(Unit)
                } else {
                    permissionState.launchPermissionRequest()
                }
            }
            MainIconButton(R.drawable.icon_translate) {
                viewModel.onTranslate(
                    state.textToTranslate,
                    context,
                    selectedSourceLang,
                    selectedTargetLang
                )
            }
            MainIconButton(R.drawable.icon_speak) {
                viewModel.textToSpeech(context, selectedTargetVoice)
            }
            MainIconButton(R.drawable.icon_delete) { viewModel.clean() }
        }

        if (state.isDownloading) {
            CircularProgressIndicator()
            Text(text = "Descargando modelo, espera un momento...")
        } else {
            OutlinedTextField(
                value = state.translateText,
                onValueChange = {},
                label = { Text(text = "Tu texto traducido...") },
                readOnly = false,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
    }

}