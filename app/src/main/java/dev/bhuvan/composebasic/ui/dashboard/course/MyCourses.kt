package dev.bhuvan.composebasic.ui.dashboard.course

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.bhuvan.composebasic.R

@Composable
fun DashboardMyCoursesCard(
    onclick : () -> Unit,
) {
    Card(
        elevation = 4.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .clickable {
                onclick()
            }
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(
                    horizontal = 10.dp,
                    vertical = 10.dp,
                )
        ) {
            Text(
                text = "BPHYS 203 - Fundamental of Normal body functions",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "Program 1 / Year 2 / Level 3 / Rotation 1",
                fontSize = 14.sp,
                color = colorResource(id = R.color.hint_text_color),
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "Jan 5, 2021 - Feb 26, 2021",
                fontSize = 14.sp,
                color = colorResource(id = R.color.hint_text_color),
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
            )
        }
    }
}

@Preview
@Composable
fun DashboardMyCoursesCardPreview() {
    DashboardMyCoursesCard(
        onclick = {}
    )
}