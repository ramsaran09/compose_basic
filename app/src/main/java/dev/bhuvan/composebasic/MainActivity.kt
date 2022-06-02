package dev.bhuvan.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.bhuvan.composebasic.ui.attendenceMarked.AttendanceMarkedScreen
import dev.bhuvan.composebasic.ui.login.LoginViewModel
import dev.bhuvan.composebasic.ui.theme.ComposeBasicTheme
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                AttendanceMarkedScreen(
                    onContinueClicked = {},
                    onBackPressed = {},
                    completedSession = "nckjadvbkjvkjv",
                    lectureDetails = "cnkjvjkvnjv",
                    percent = 75f,
                )
            }
        }
    }
}
