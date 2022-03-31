package dev.bhuvan.composebasic.ui.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import dev.bhuvan.composebasic.R
import kotlinx.coroutines.launch

@Composable
fun LoginForm(
    email: String,
    onEmailChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    isValidInput: Boolean,
    onButtonClick : () -> Unit
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    var isPasswordVisible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(all = 10.dp)
    ) {
        OutlinedTextField(
            value = email,
            placeholder = {
                Text(
                    text = "Email Id",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.LightGray
                    )
                )
            },
            onValueChange = {
                onEmailChanged(it)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            leadingIcon = {
                Icon(
                painter = painterResource(id = R.drawable.ic_user_image),
                contentDescription = "")
            },
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            placeholder = {
                Text(
                    text = "Password",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.LightGray
                    )
                )
            },
            onValueChange = {
                onPasswordChanged(it)
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None
            else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_password),
                    contentDescription = "")
            },
            trailingIcon = {
                IconButton(onClick = {
                    isPasswordVisible = !isPasswordVisible
                }) {
                    Icon(
                        imageVector = if (isPasswordVisible)
                            Icons.Filled.Visibility
                        else
                            Icons.Filled.VisibilityOff,
                        contentDescription = "Password Visibility"
                    )
                }
            } ,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                showToast(context, email, password)
                onButtonClick()
                      },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            enabled = isValidInput,
        ) {
            Text(
                text = "Submit"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginFormPreview() {
    LoginForm(
        email = "ram@gmail.com",
        onEmailChanged = { },
        password = "123456789",
        onPasswordChanged = { },
        isValidInput = true,
        onButtonClick = {},
    )
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        email = "ram@gmail.com",
        onEmailChanged = { },
        password = "123456789",
        onPasswordChanged = { },
        isValidInput = false,
        onButtonClick = { },
        state = LoginState.FAILED,
    )
}

@Composable
fun AppTopBar(
    onShareClicked : () -> Unit
) {
    TopAppBar(elevation = 10.dp) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            val (title, share) = createRefs()
            Text(
                text = "Login Screen",
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(share.start)
                    width = Dimension.fillToConstraints
                },
                fontSize = 18.sp,
            )
            IconButton(
                onClick = { onShareClicked() },
                modifier = Modifier.constrainAs(share) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
            ) {
                Icon(Icons.Filled.Share,"Share Icon")
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun LoginScreen(
    email: String,
    onEmailChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    isValidInput: Boolean,
    onButtonClick: () -> Unit,
    state : LoginState,
) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        topBar = {
            AppTopBar {
                coroutineScope.launch {
                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    } else bottomSheetScaffoldState.bottomSheetState.collapse()
                }
            }
        },
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Text(text = "Hello from sheet",textAlign = TextAlign.Center)
            }
        }, sheetPeekHeight = 0.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "Digi Class",
                modifier = Modifier
                    .size(100.dp, 100.dp)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            when (state) {
                LoginState.CURRENT -> {
                    LoginForm(
                        email = email,
                        onEmailChanged = onEmailChanged,
                        password = password,
                        onPasswordChanged = onPasswordChanged,
                        isValidInput = isValidInput,
                        onButtonClick = onButtonClick,
                    )
                }
                LoginState.LOADING -> {
                    CircularProgressIndicator()
                }
                LoginState.FAILED -> Text(text = "Logged In Failed")
                else -> Text(text = "Logged In Successfully")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Forgot password",
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 10.dp)
                    .align(Alignment.Start),
                textAlign = TextAlign.Start,
            )
        }
    }
}

private fun showToast(context: Context, email: String, password: String) {
    Toast.makeText(context, "$email : $password", Toast.LENGTH_SHORT).show()
}
