package dev.bhuvan.composebasic.ui.dashboard.document

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.bhuvan.composebasic.R

@Composable
fun DocumentView() {
    Column(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 5.dp),
    ) {
        Row {
            Box(contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "file icon"
                )
                Text(
                    text = "Png",
                    fontSize = 5.sp,
                    color = colorResource(id = R.color.hint_text_color),
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Spacer(modifier = Modifier.padding(6.dp))
            Text(
                modifier = Modifier.padding(end = 15.dp),
                text = "Introduction to anatomy.ppt",
                fontSize = 14.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "L1,L2,L3,L4,L5...  • CODE - Course Name...",
            fontSize = 12.sp,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.roboto_regular)),
        )
        Divider(
            color = colorResource(R.color.grey_200),
            thickness = 1.dp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DocumentViewPreview() {
    DocumentView()
}