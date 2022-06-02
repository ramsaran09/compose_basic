package dev.bhuvan.composebasic.ui.component


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.rememberPermissionState
import dev.bhuvan.composebasic.ui.theme.ComposeBasicTheme


@Composable
@ExperimentalPermissionsApi
fun RequestPermission(
    modifier: Modifier = Modifier,
    permissionGranted: (Boolean) -> Unit,
    dismissRequest: () -> Unit,
    permission: String,
    title: String,
    message: String,
) {
    val cameraPermissionState = rememberPermissionState(permission = permission)

    when (cameraPermissionState.status) {
        PermissionStatus.Granted -> permissionGranted(true)
        is PermissionStatus.Denied -> {
            PermissionRequestCard(
                modifier = modifier,
                onOkayClick = {
                    cameraPermissionState.launchPermissionRequest()
                },
                onNopeClick = {
                    permissionGranted(false)
                    dismissRequest()
                },
                title = title,
                message = message,
            )
        }
    }
}

@Composable
fun PermissionRequestCard(
    modifier: Modifier = Modifier,
    onOkayClick: () -> Unit,
    onNopeClick: () -> Unit,
    title: String,
    message: String,
) {

    Card(
        modifier = modifier.then(Modifier.padding(8.dp)),
        shape = RoundedCornerShape(6.dp),
        elevation = 5.dp,
        border = BorderStroke(1.dp, Color.Gray.copy(alpha = 0.5f))
    ) {
        Column(modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier.padding(3.dp),
                text = message,
                style = MaterialTheme.typography.body1
            )

            Spacer(modifier = Modifier.height(8.dp))
            Divider()

            Row(
                modifier = Modifier.align(Alignment.End),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = onNopeClick) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Nope",
                        style = MaterialTheme.typography.subtitle1
                    )
                }

                TextButton(onClick = onOkayClick) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Okay",
                        style = MaterialTheme.typography.subtitle1,
                        color = MaterialTheme.colors.primary,
                    )
                }
            }
        }
    }
}

@Composable
@ExperimentalPermissionsApi
fun RequestPermissions(
    permissions: List<String>,
    modifier: Modifier = Modifier,
    permissionGranted: (Boolean) -> Unit,
    dismissRequest: () -> Unit,
    title: String,
    message: String,
) {
    val cameraPermissionState = rememberMultiplePermissionsState(permissions = permissions)

    when {
        cameraPermissionState.allPermissionsGranted -> permissionGranted(true)
        cameraPermissionState.shouldShowRationale ||
                !cameraPermissionState.allPermissionsGranted -> {
            PermissionRequestCard(
                modifier = modifier,
                onOkayClick = {
                    cameraPermissionState.launchMultiplePermissionRequest()
                },
                onNopeClick = dismissRequest,
                title = title,
                message = message,
            )
        }
        else -> permissionGranted(false)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PermissionRequestPreview() {
    ComposeBasicTheme {
        PermissionRequestCard(
            onOkayClick = {},
            onNopeClick = {},
            title = "Camera Permission Required",
            message = "To open camera we need camera permission. Please provide camera permission in the next dialog"
        )
    }
}