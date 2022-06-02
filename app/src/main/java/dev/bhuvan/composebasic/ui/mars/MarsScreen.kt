package dev.bhuvan.composebasic.ui.mars

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import dev.bhuvan.composebasic.model.MarsImageDataModel


@Composable
fun MessageList(
    uiState: MarsState,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (uiState) {
            MarsState.Loading -> CircularProgressIndicator()
            is MarsState.Error -> Text(text = uiState.msg)
            is MarsState.Completed -> {
                ShowMarsList(
                    marsList = uiState.marsImageDataModel,
                    onCardSelected = { }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowMessageCard() {
    ShowMarsList(
        marsList = arrayListOf() ,
        onCardSelected = { }
    )
}

@Composable
fun ShowMarsList(
    marsList : List<MarsImageDataModel>,
    onCardSelected: (MarsImageDataModel) -> Unit,
) {
    LazyColumn{
        items(marsList){ message ->
            MessageCard(
                id = message.id,
                camera = message.camera.name,
                imageUrl = message.img_src,
                onCardSelected = { onCardSelected(message) }
            )
        }
    }
}

@Composable
fun MessageCard(
    id : String,
    camera : String,
    imageUrl : String,
    onCardSelected : () -> Unit,
) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = "Mars Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.clickable { onCardSelected() }
        ) {
            Text(
                text = id,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = camera,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageCardPreview() {
    MessageCard(
        id = "1",
        camera = "NASA 11",
        imageUrl = "https://baja.com.sa/img/loader2.gif",
        onCardSelected = { }
    )
}
