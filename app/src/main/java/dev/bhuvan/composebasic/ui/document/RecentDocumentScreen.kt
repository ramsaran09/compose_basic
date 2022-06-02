package dev.bhuvan.composebasic.ui.document

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import dev.bhuvan.composebasic.R
import dev.bhuvan.composebasic.ui.component.Tab
import dev.bhuvan.composebasic.ui.component.TopBar
import dev.bhuvan.composebasic.ui.theme.digi_blue

@Composable
fun RecentDocumentScreen(
    title: String,
    searchText: String,
    onSearchValueChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
    tabTitles: List<String>,
    onTabSelected: (Int) -> Unit,
    selectedTab: Int,
    onRefreshAction: (Boolean) -> Unit,
    isRefreshing: Boolean,
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.White,
        scaffoldState = scaffoldState,
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CollapsingToolbarBar(
                title = title,
                searchText = searchText,
                onSearchValueChanged = onSearchValueChanged,
                onBackPressed = onBackPressed,
                tabTitles = tabTitles,
                onTabSelected = onTabSelected,
                selectedTab = selectedTab,
            )
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
                onRefresh = { onRefreshAction(true) },
                indicator = { refreshing, refreshTrigger ->
                    SwipeRefreshIndicator(
                        state = refreshing,
                        refreshTriggerDistance = refreshTrigger,
                        scale = true,
                        backgroundColor = colorResource(id = R.color.grey_200),
                        contentColor = colorResource(id = R.color.digi_blue)
                    )
                }
            ){
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 5.dp)
                        .fillMaxWidth()
                ){
                    items(10){ index ->
                        Text(text = "Document $index")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RecentDocumentScreenPreview() {
    RecentDocumentScreen(
        title = " Recent Documents",
        searchText = "",
        onSearchValueChanged = {},
        onBackPressed = {},
        tabTitles = listOf("Starred","All Documents"),
        onTabSelected= {},
        selectedTab = 1,
        isRefreshing = false,
        onRefreshAction = {},
    )
}

@Composable
fun CollapsingToolbarBar(
    title: String,
    searchText: String,
    onSearchValueChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
    tabTitles: List<String>,
    onTabSelected: (Int) -> Unit,
    selectedTab: Int,
) {

    Box(
        modifier = Modifier.height(120.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_lecture),
            contentDescription = "lecture image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = digi_blue.copy(0.7f)),
            verticalArrangement = Arrangement.Top,
        ) {
            TopBar(
                title = title,
                searchText = searchText,
                onSearchValueChanged = onSearchValueChanged,
                onBackPressed = onBackPressed,
            )
            Tab(
                items = tabTitles,
                onItemSelected = onTabSelected,
                selectedItem = selectedTab
            )
        }

    }
}
