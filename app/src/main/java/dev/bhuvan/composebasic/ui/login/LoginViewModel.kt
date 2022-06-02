package dev.bhuvan.composebasic.ui.login

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class LoginViewModel : ViewModel() {
    var email by mutableStateOf("")
    private set
    var password by mutableStateOf("")
    private set
    private val textPattern: Pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$")

    private val _loginState : MutableState<LoginState> = mutableStateOf(LoginState.Ideal)
    val loginState : State<LoginState> = _loginState

    fun onEmailEntered(emailId : String) {
        email = emailId
    }

    fun onPasswordEntered(password : String) {
        this.password = password
    }

    fun isEmailValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotEmpty()
    }

    fun isPasswordValid(): Boolean {
        return textPattern.matcher(password).matches() && password.isNotEmpty()
    }

    fun onSubmitClicked() {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            delay(5000)
            val randomNumber = (1..10).random()
//            if (randomNumber % 2 == 0) _loginState.value = LoginState.COMPLETED
//            else _loginState.value = LoginState.FAILED
        }
    }
}