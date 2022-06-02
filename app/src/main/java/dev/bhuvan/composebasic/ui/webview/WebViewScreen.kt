package dev.bhuvan.composebasic.ui.webview

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.web.*
import dev.bhuvan.composebasic.R

@Preview(showBackground = true)
@Composable
fun WebViewScreenPreview() {
    WebViewScreen(
//        url = "https://google.com",
//        title = "Google",
    )
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen(
    title : String = "document",
    url : String = "https://google.com",
) {
    val state = rememberWebViewState(url = url)
    val navigator = rememberWebViewNavigator()

    Column {
        TopAppBar(
            backgroundColor = Color.White,
            title = {
                Text(
                    text = title,
                    color = Color.Black,
                )
                    },
            navigationIcon = {
                if (navigator.canGoBack) {
                    IconButton(
                        onClick = { navigator.navigateBack() }
                    ) {
                        Icon(
                            painterResource(id = R.drawable.ic_password),
                            contentDescription = "Back",
                        )
                    }
                }
            }
        )

        val loadingState = state.loadingState
        if (loadingState is LoadingState.Loading) {
            LinearProgressIndicator(
                progress = loadingState.progress,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // A custom WebViewClient and WebChromeClient can be provided via subclassing
        val webClient = remember {
            object : AccompanistWebViewClient() {
                override fun onPageStarted(
                    view: WebView?,
                    url: String?,
                    favicon: Bitmap?
                ) {
                    super.onPageStarted(view, url, favicon)
                    Log.d("Accompanist WebView", "Page started loading for $url")
                }
            }
        }

        WebView(
            state = state,
            modifier = Modifier.weight(1f),
            navigator = navigator,
            onCreated = { webView ->
                webView.settings.javaScriptEnabled = true
                webView.settings.setSupportMultipleWindows(true)
                webView.settings.allowFileAccess = true
                webView.settings.domStorageEnabled = true
                webView.settings.javaScriptCanOpenWindowsAutomatically = true
            },
            client = webClient
        )
    }
}