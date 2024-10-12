package cl.bootcamp.clasetraduccion.translator

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MainIconButton(
    icon: Int,
    onClick: () -> Unit
) {
    IconButton(onClick = {onClick()}) {
        Icon(
            painterResource(icon),
            "",
            modifier = Modifier
                .size(24.dp)
        )
    }
}