package dev.bhuvan.composebasic.ui.login.data

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.bhuvan.composebasic.repository.MarsImageRepository
import dev.bhuvan.composebasic.responsehandler.CustomResponse
import dev.bhuvan.composebasic.ui.login.LoginState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class LoginViewModel(
    private val authRepo: MarsImageRepository
) : ViewModel() {
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    private val textPattern: Pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")

    private val _loginState: MutableState<LoginState> = mutableStateOf(LoginState.Ideal)
    val loginState: State<LoginState> = _loginState

    fun onEmailEntered(emailId: String) {
        email = emailId
    }

    fun onPasswordEntered(password: String) {
        this.password = password
    }

    fun isEmailValid(): Boolean {
        return true
//        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotEmpty()
    }

    fun isPasswordValid(): Boolean {
        return true
//        return textPattern.matcher(password).matches() && password.isNotEmpty()
    }

    fun onSubmitClicked() {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            delay(2000)
//            when (val response = authRepo.getLoginResponse()) {
//                is CustomResponse.Success -> {
//                    _loginState.value = LoginState.Completed(response.data)
//                    Log.e("_loginState_log", _loginState.value.toString())
//                }
//                is CustomResponse.Failure -> {
//                    _loginState.value = LoginState.Failed("Invalid Credentials")
//                }
//            }
        }
    }
}