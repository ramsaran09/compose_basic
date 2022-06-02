package dev.bhuvan.composebasic.ui.login

import dev.bhuvan.composebasic.ui.login.data.LoginResponse

sealed class LoginState {
    object Ideal:LoginState()
    object Loading:LoginState()
    data class Completed(val loginResponse: LoginResponse):LoginState()
    data class Failed(val message:String):LoginState()
}