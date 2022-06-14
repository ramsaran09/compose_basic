package dev.bhuvan.composebasic.ui.dashboard.navigationDrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.bhuvan.composebasic.R
import dev.bhuvan.composebasic.ui.theme.headerGradientEnd
import dev.bhuvan.composebasic.ui.theme.headerGradientStart
import java.util.*

@Composable
fun DrawerHeader(
    userName: String,
    employeeId: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    listOf(
                        headerGradientStart, headerGradientEnd
                    )
                )
            )
            .padding(horizontal = 20.dp),
    ) {
        Spacer(modifier = Modifier.padding(20.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_account_circle),
            contentDescription = "user image",
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.name),
            fontSize = 14.sp,
            color = colorResource(id = R.color.white),
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            modifier = Modifier,
            text = userName,
            fontSize = 14.sp,
            color = colorResource(id = R.color.white),
            fontFamily = FontFamily(Font(R.font.roboto_regular)),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.employee_id),
            fontSize = 14.sp,
            color = colorResource(id = R.color.white),
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            modifier = Modifier,
            text = employeeId,
            fontSize = 14.sp,
            color = colorResource(id = R.color.white),
            fontFamily = FontFamily(Font(R.font.roboto_regular)),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.padding(4.dp))
    }
}

@Preview
@Composable
fun DrawerHeaderPreview() {
    DrawerHeader(
        "Ram",
        "12345"
    )
}

@Composable
fun DrawerBody(
    modifier: Modifier = Modifier,
    items: List<MenuItem>,
    itemTextStyle: TextStyle = TextStyle(fontSize = 16.sp),
    onItemClick: (MenuItem) -> Unit,
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(horizontal = 20.dp, vertical = 5.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = item.title,
                    style = itemTextStyle,
                )
            }
        }
    }
}

@Preview
@Composable
fun SignOutButtonPreview() {
    SignOutButton(
        onClicked = {}
    )
}

@Composable
fun SignOutButton(
    onClicked: () -> Unit,
) {
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = colorResource(id = R.color.text_color),
        contentColor = colorResource(id = R.color.text_color)
    )
    Button(
        colors = mainButtonColor,
        onClick = {
            onClicked()
        },
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp, end = 30.dp, start = 30.dp)
            .height(50.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
    ) {
        Text(
            text = stringResource(R.string.sign_out).uppercase(Locale.getDefault()),
            color = colorResource(id = R.color.white),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
        )
    }
}

@Preview
@Composable
fun DrawerBodyPreview() {
    DrawerBody(
        items = getDrawerBodyList(),
        onItemClick = {},
    )
}

@Composable
private fun getDrawerBodyList() =
    listOf(
        MenuItem(
            title = stringResource(id = R.string.dashboard),
            icon = ImageVector.vectorResource(id = R.drawable.ic_dashboard),
        ),
        MenuItem(
            title = stringResource(id = R.string.courses),
            icon = ImageVector.vectorResource(id = R.drawable.ic_courses_dashboard_menu),
        ),
        MenuItem(
            title = stringResource(id = R.string.course_coordinator),
            icon = ImageVector.vectorResource(id = R.drawable.ic_calendar),
        ),
        MenuItem(
            title = stringResource(id = R.string.calendar),
            icon = ImageVector.vectorResource(id = R.drawable.ic_calendar),
        ),
        MenuItem(
            title = stringResource(id = R.string.profile),
            icon = ImageVector.vectorResource(id = R.drawable.ic_icon_awesome_award),
        ),
        MenuItem(
            title = stringResource(id = R.string.help),
            icon = ImageVector.vectorResource(id = R.drawable.ic_help),
        )
    )