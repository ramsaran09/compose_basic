package dev.bhuvan.composebasic.ui.mars

import androidx.compose.runtime.Composable

@Composable
fun MarsScreenRoute(
    viewModel: MarsViewModel,
) {
    MessageList(
        uiState = viewModel.marsState,
    )
}