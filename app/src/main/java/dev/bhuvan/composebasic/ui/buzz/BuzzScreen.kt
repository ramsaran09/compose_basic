package dev.bhuvan.composebasic.ui.buzz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SurpriseQuizQuestion(
    isExpand : Boolean,
    attendanceCount : String,
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(5.dp))
    ) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    textAlign = TextAlign.Start,
                    text = "01.",
                    color = Color.Black
                )
                Text(
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Start,
                    text = "Where is the node located?",
                    color = Color.Black
                )
                Icon(
                    imageVector = if (!isExpand) Icons.Default.ExpandLess
                    else Icons.Default.ExpandMore,
                    contentDescription = "expand"
                )
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Text(text = "10 Responses received")
            Spacer(modifier = Modifier.padding(4.dp))
        }

    }
}