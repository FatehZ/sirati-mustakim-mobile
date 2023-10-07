package com.ktxdevelopment.siratimustakim.android.ui.screens.postdetail

import android.text.SpannableString
import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.ktxdevelopment.siratimustakim.android.util.NetType
import kotlin.reflect.KFunction1

@Composable
fun PostDetailScreen(
    state: PostDetailScreenState,
    onTriggerEvent: KFunction1<PostDetailEvent, Unit>,
    postId: String,
    netType: NetType
) {

    LaunchedEffect(key1 = true) {
        onTriggerEvent(PostDetailEvent.GetPostEvent(postId, netType))
    }

    // Compose the UI based on the state
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        // Use LazyColumn for better performance with large content
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Display the title with a larger font
            item {
                Text(
                    text = state.post?.title ?: "",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Display the content parsed from HTML
            item {
                ParsedHtmlContent(html = state.post?.content ?: "")
            }
        }
    }
}

@Composable
fun ParsedHtmlContent(html: String) {
//    val spannableString = remember { SpannableString(html) }

    // Use a library like AndroidView to render HTML content
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
//                settings.javaScriptEnabled = true  //todo check if js is needed
                loadDataWithBaseURL(null, html, "text/html", "utf-8", null)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 200.dp),
    )
}
