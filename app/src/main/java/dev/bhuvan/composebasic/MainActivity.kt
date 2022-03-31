package dev.bhuvan.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import dev.bhuvan.composebasic.ui.login.LoginScreenRoute
import dev.bhuvan.composebasic.ui.login.LoginViewModel
import dev.bhuvan.composebasic.ui.theme.ComposeBasicTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: LoginViewModel by viewModels()
            ComposeBasicTheme {
                LoginScreenRoute(
                    viewModel = viewModel,
                )
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun MessageCard() {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = "Saran",
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = "Its time for the game",
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}
*/
