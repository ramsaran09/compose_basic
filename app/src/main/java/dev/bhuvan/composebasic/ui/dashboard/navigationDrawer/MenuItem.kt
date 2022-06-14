package dev.bhuvan.composebasic.ui.dashboard.navigationDrawer

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id : String? = null,
    val title : String,
    val icon : ImageVector,
    val contentDescription : String? = null,
)
