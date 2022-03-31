package dev.bhuvan.composebasic.ui.login

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginScreenRoute(
    viewModel: LoginViewModel,
) {
    LoginScreen(
        email = viewModel.email,
        onEmailChanged = { viewModel.onEmailEntered(it) },
        password = viewModel.password,
        onPasswordChanged = { viewModel.onPasswordEntered(it) },
        isValidInput = viewModel.isPasswordValid() && viewModel.isEmailValid(),
        onButtonClick = { viewModel.onSubmitClicked() },
        state = viewModel.loginState.value,
    )
}