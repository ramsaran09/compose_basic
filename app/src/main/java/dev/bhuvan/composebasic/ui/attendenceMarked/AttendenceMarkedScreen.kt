package dev.bhuvan.composebasic.ui.attendenceMarked

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.bhuvan.composebasic.R
import dev.bhuvan.composebasic.utils.roundOff
import java.util.*

@Preview
@Composable
fun AttendanceMarkedScreenPreview() {
    AttendanceMarkedScreen(
        onContinueClicked = {},
        onBackPressed = {},
        completedSession = "22/25 session details",
        lectureDetails = "L03 -   CNS Module   10-11AM",
        percent = 75f,
    )
}

@Composable
fun AttendanceMarkedScreen(
    onContinueClicked : () -> Unit,
    onBackPressed: () -> Unit,
    completedSession: String,
    lectureDetails : String,
    percent : Float,
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = colorResource(id = R.color.grey_200),
        scaffoldState = scaffoldState,
        topBar = {
            ToolBar(
                onBackPressed = {
                    onBackPressed()
                },
                title = stringResource(id = R.string.str_attendance)
            )
        },
        bottomBar = {
            ContinueLectureButton(
                onClicked = {
                    onContinueClicked()
                }
            )
        },
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, bottom = paddingValue.calculateBottomPadding())
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                AttendanceUi(
                    completedSession = completedSession,
                    lectureDetails = lectureDetails,
                    percent = percent,
                )
            }
        }
    }

}

@Preview
@Composable
fun ContinueLectureButtonPreview() {
    ContinueLectureButton(onClicked = {})
}

@Composable
fun ContinueLectureButton(
    onClicked: () -> Unit,
) {
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = colorResource(id = R.color.loginBlue),
        contentColor = colorResource(id = R.color.loginBlue)
    )
    Button(
        colors = mainButtonColor,
        onClick = {
            onClicked()
        },
        modifier = Modifier
            .padding(top = 20.dp, bottom = 10.dp, end = 20.dp, start = 20.dp)
            .height(50.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
    ) {
        Text(
            text = stringResource(R.string.continue_to_lecture).uppercase(Locale.getDefault()),
            color = colorResource(id = R.color.white),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AttendanceUiPreview() {
    AttendanceUi(
        completedSession = "22/25 session",
        lectureDetails = "",
        percent = 50f,
    )
}

@Composable
fun AttendanceUi(
    completedSession: String,
    lectureDetails : String,
    percent : Float,
) {

    Column(
        modifier = Modifier.padding(
            top = 30.dp,
            start = 5.dp,
            end = 5.dp,
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_attendance_success_icon),
            contentDescription = "Attendance success",
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = stringResource(id = R.string.attendance_marked_successfully),
            color = Color.Green,
            fontSize = 17.sp,
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            modifier = Modifier.padding(5.dp),
            text = lectureDetails,
            color = colorResource(id = R.color.text_color),
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.padding(15.dp))
        CircularProgressbarWithAnimation(
            number = percent
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            text = completedSession,
            fontSize = 16.sp,
            color = colorResource(id = R.color.black),
        )
        Spacer(modifier = Modifier.padding(15.dp))
    }
}

@Composable
fun ToolBar(
    onBackPressed: () -> Unit,
    title : String,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = colorResource(id = R.color.text_color),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Back button",
                modifier = Modifier.clickable {
                    onBackPressed()
                },
                tint = Color.Black
            )
        },
        backgroundColor = Color.White,
    )
}

@Preview
@Composable
fun ToolBarPreview() {
    ToolBar(
        onBackPressed = {},
        title = "Attendance"
    )
}

@Composable
fun CircularProgressbarWithAnimation(
    number: Float = 70f,
    numberStyle: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    size: Dp = 120.dp,
    indicatorThickness: Dp = 20.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
    foregroundIndicatorColor: Color = Color(0xFF35898f),
    backgroundIndicatorColor: Color = Color.LightGray.copy(alpha = 0.3f)
) {

    // It remembers the number value
    var numberR by remember {
        mutableStateOf(0f)
    }

    // Number Animation
    val animateNumber = animateFloatAsState(
        targetValue = numberR,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    // This is to start the animation when the activity is opened
    LaunchedEffect(Unit) {
        numberR = number
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = size)
    ) {
        Canvas(
            modifier = Modifier
                .size(size = size)
        ) {

            // Background circle
            drawCircle(
                color = backgroundIndicatorColor,
                radius = size.toPx() / 2,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round)
            )

            val sweepAngle = (animateNumber.value / 100) * 360

            // Foreground circle
            drawArc(
                color = foregroundIndicatorColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(indicatorThickness.toPx(), cap = StrokeCap.Round)
            )
        }

        // Text that shows number inside the circle
        Text(
            text = "${(animateNumber.value).toDouble().roundOff()}%",
            style = numberStyle
        )
    }
}