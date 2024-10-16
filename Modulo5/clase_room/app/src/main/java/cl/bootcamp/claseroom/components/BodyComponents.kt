package cl.bootcamp.claseroom.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.bootcamp.claseroom.R

@Composable
fun MainTitle(title: String) {
    Text(
        text = title,
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun MainTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 15.dp)
    )
}

@Composable
fun formatTiempo(tiempo: Long): String {
    val segundos = (tiempo / 1000) % 60
    val minutos = (tiempo / 1000 / 60) % 60
    val horas = tiempo / 1000 / 3600
    return String.format("%02d:%02d:%02d", horas, minutos, segundos)
}

@Composable
fun CronoCard(
    title: String,
    crono: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .padding(vertical = 5.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_timer),
                    "",
                    tint = Color.Gray
                )
                Text(
                    text = crono,
                    fontSize = 20.sp
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}












