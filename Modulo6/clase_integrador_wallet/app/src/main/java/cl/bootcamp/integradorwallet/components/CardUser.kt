package cl.bootcamp.integradorwallet.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CardUser(
    nombre: String,
    pais: String,
    imagen: String,
    cuenta: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onClick() }
            .shadow(5.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(11.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column {
                ImageUser(imagen)
            }
            Column(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = nombre, fontWeight = FontWeight.Bold)
                Text(text = pais, color = Color.Gray)
                Text(text = cuenta, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun ImageUser(imagen: String) {
    val image = rememberAsyncImagePainter(model = imagen)

    Image(
        painter = image,
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(90.dp)
    )
}