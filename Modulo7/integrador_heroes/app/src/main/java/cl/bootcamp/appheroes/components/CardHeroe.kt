package cl.bootcamp.appheroes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cl.bootcamp.appheroes.ui.theme.bgColor
import cl.bootcamp.appheroes.ui.theme.textColor
import coil.compose.rememberAsyncImagePainter

@Composable
fun CardHeroe(
    nombre: String,
    aparicion: String,
    imagen: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { onClick() }
            .shadow(10.dp),
        shape = RoundedCornerShape(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = bgColor,
            contentColor = textColor
        )
    ) {
        Column {
            Text(text = nombre, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(10.dp))
            ImageHeroe(imagen)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = aparicion, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun ImageHeroe(imagen: String) {
    val imagen = rememberAsyncImagePainter(model = imagen)

    Image(
        painter = imagen,
        contentDescription = "Imagen Heroe",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    )
}