package cl.bootcamp.clasecomponents.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Space() {
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun BotonNormal() {
    Button(onClick = {}) {
        Text( text = "button", fontSize = 20.sp )
    }
}

@Composable
fun BotonDeshabilitado() {
    Button(onClick = {}, enabled = false) {
        Text( text = "button", fontSize = 20.sp )
    }
}

@Composable
fun BotonTexto() {
    TextButton(onClick = {}) {
        Text( text = "button", fontSize = 20.sp )
    }
}

@Composable
fun BotonOutline() {
    OutlinedButton(onClick = {}, border = BorderStroke(3.dp, Color.Blue)) {
        Text( text = "button", fontSize = 20.sp)
    }
}

@Composable
fun BotonIcono() {
    IconButton(onClick = {}) {
        Icon(
            Icons.Default.Home,
            contentDescription = "Icono",
            tint = Color.Magenta,
            modifier = Modifier
                .size(50.dp)
        )
    }
}

@Composable
fun BotonSwitch() {
    var switched by remember { mutableStateOf(false) }

    Switch(
        checked = switched,
        onCheckedChange = { switched = it },
        colors = SwitchDefaults.colors(
            checkedTrackColor = Color.Magenta,
            checkedThumbColor = Color.Blue,
            uncheckedTrackColor = Color.Black,
            uncheckedThumbColor = Color.Gray
        )
    )
}

@Composable
fun BotonFloating() {
    FloatingActionButton(
        onClick = {},
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        Icon(
            Icons.Default.Add,
            contentDescription = "",
            modifier = Modifier
                .size(30.dp)
        )
    }
}

@Composable
fun BotonDarkMode(darkMode: MutableState<Boolean>) {
    Button(onClick = {
        darkMode.value = !darkMode.value
    }) {
        Icon(
            Icons.Default.Star,
            contentDescription = "DarkMode"
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Dark Mode",
            fontSize = 20.sp
        )
    }
}