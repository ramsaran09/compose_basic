package dev.bhuvan.composebasic.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import dev.bhuvan.composebasic.ui.theme.ComposeBasicTheme
import dev.bhuvan.composebasic.ui.theme.digi_blue

@Composable
fun Tab(
    items: List<String>,
    onItemSelected: (Int) -> Unit,
    selectedItem: Int,
) {
    LazyRow(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(start = 30.dp, top = 20.dp, bottom = 15.dp)
    ) {
        itemsIndexed(items) { index, item ->
            TabItem(
                value = item,
                onClick = { onItemSelected(index) },
                isSelected = selectedItem == index
            )
        }
    }
}

@Composable
private fun TabItem(
    value: String,
    onClick: () -> Unit,
    isSelected: Boolean,
) {
    val backgroundColor = if (isSelected) Color.White else Color.White.copy(alpha = 0.35f)
    val textColor = if (isSelected) digi_blue else Color.Black
    Box(
        modifier = Modifier
            .height(30.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = backgroundColor)
            .clickable(enabled = !isSelected, onClick = onClick)
            .padding(horizontal = 15.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = value,
            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
            color = textColor,
        )
    }
}

class TabItemPreviewProvider : PreviewParameterProvider<Boolean> {
    override val values: Sequence<Boolean> = sequenceOf(true, false)
}

@Preview(showBackground = false)
@Composable
private fun TabItemPreview(
    @PreviewParameter(TabItemPreviewProvider::class) isSelected: Boolean,
) {
    ComposeBasicTheme {
        TabItem(
            value = "Document",
            onClick = {},
            isSelected = isSelected
        )
    }
}

@Preview(showBackground = false)
@Composable
private fun TabPreview() {
    ComposeBasicTheme {
        var selectedItem by remember { mutableStateOf(0) }
        Tab(
            items = listOf("All", "Document", "Starred"),
            onItemSelected = { selectedItem = it },
            selectedItem = selectedItem
        )
    }
}