package dev.bhuvan.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.bhuvan.composebasic.ui.mars.MarsScreenRoute
import dev.bhuvan.composebasic.ui.mars.MarsViewModel
import dev.bhuvan.composebasic.ui.theme.ComposeBasicTheme
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {

    private val viewModel: MarsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                MarsScreenRoute(
                    viewModel = viewModel,
                )
            }
        }
    }
}
