package dev.bhuvan.composebasic.ui.dashboard.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.bhuvan.composebasic.R

@Composable
fun DashboardChatItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 16.dp)
            .background(Color.White),
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_student_group_chat),
                contentDescription = "chat icon",
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Course Code - Course 1",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.digi_class_clr),
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = "All Course Groups MG1, MG1, MG1, MG1, MG1, MG1, MG1,",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.hint_text_color),
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Column {
                Text(
                    text = "Yesterday",
                    fontSize = 10.sp,
                    color = colorResource(id = R.color.notification_green),
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Row {
                    Text(
                        text = stringResource(id = R.string.at_symbol),
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.tab_selected_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        modifier = Modifier
                            .background(
                                color = colorResource(id = R.color.digi_blue),
                                shape = CircleShape
                            )
                            .padding(3.dp),
                        text = "10",
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.white),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    )
                }
            }
        }
        Divider(
            color = colorResource(R.color.grey_200),
            thickness = 1.dp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardChatItemPreview() {
    DashboardChatItem()
}