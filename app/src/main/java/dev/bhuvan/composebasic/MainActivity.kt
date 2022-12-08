package dev.bhuvan.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.bhuvan.composebasic.network.NetworkSpeedHelper
import dev.bhuvan.composebasic.network.Speed
import dev.bhuvan.composebasic.ui.attendenceMarked.AttendanceMarkedScreen
import dev.bhuvan.composebasic.ui.login.LoginViewModel
import dev.bhuvan.composebasic.ui.theme.ComposeBasicTheme
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModel()

    private val networkSpeedHelper: NetworkSpeedHelper by lazy {
        NetworkSpeedHelper(this, object : NetworkSpeedHelper.OnNetworkUpdate {
            override fun onUpdate(speed: Speed?) {
                //add ur logics when internet speed is low
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkSpeedHelper.initNetworkSpeedListener()
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

    override fun onDestroy() {
        super.onDestroy()
        networkSpeedHelper.removeSpeedListener()
    }
}
