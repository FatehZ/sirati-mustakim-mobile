package com.ktxdevelopment.siratimustakim.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ktxdevelopment.siratimustakim.android.ui.screens.postdetail.ParsedHtmlContent
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit

@Composable
fun PostCard(post: PostLit, onClickPost: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = {
                onClickPost(post.id)
            })
            .background(MaterialTheme.colors.background),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = post.title,
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary
                ),
                maxLines = 1
            )
            Text(
                text = post.subtitle,
                style = MaterialTheme.typography.body2.copy(
                    color = MaterialTheme.colors.primaryVariant
                ),
                maxLines = 1
            )
        }
    }
}
@Preview("PostCard")
@Composable
fun PostCardPreview() {

}