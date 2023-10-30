package com.ktxdevelopment.siratimustakim.android.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit

@Composable
fun PostListComponent(data: List<PostLit>, onClickPost: (String) -> Unit) {
    return LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(data) { post ->
            PostCard(post = post, onClickPost = onClickPost)
        }
    }
}