package cl.bootcamp.todolistapp.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cl.bootcamp.todolistapp.model.ProductoState

@Composable
fun Modal(
    title: String,
    onDismissClick: () -> Unit,
    onConfirmClick: @Composable () -> Unit,
    onText: @Composable () -> Unit
) {
    AlertDialog(
        title = { Text(text = title) },
        shape = RoundedCornerShape(10.dp),
        onDismissRequest = onDismissClick,
        text = onText,
        confirmButton = onConfirmClick
    )
}

@Composable
fun ButtonModal(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick
    ) { Text(text = text) }
}

@Composable
fun CardProduct(
    item: ProductoState,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .border(
                border = BorderStroke(
                    2.dp, Color(0XFF018786)
                ),
                shape = RoundedCornerShape(20)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = item.nombre,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Cant: ${item.cantidad}",
            modifier = Modifier.padding(8.dp)
        )
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            IconButton(onClick = onEditClick) {
                Icon(Icons.Default.Edit, null)
            }
            IconButton(onClick = onDeleteClick) {
                Icon(Icons.Default.Delete, null)
            }
        }
    }
}