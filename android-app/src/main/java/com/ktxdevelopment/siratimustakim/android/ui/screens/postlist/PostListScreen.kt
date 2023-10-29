@file:OptIn(ExperimentalFoundationApi::class)

package com.ktxdevelopment.siratimustakim.android.ui.screens.postlist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ktxdevelopment.siratimustakim.android.ui.components.PostCard
import com.ktxdevelopment.siratimustakim.android.ui.screens.postdetail.ParsedHtmlContent
import com.ktxdevelopment.siratimustakim.android.util.NetType
import com.ktxdevelopment.siratimustakim.android.util.UiState
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.reflect.KFunction1

@Composable
fun PostListScreen(
    mState: MutableStateFlow<PostListScreenState>,
    onTriggerEvent: KFunction1<PostListEvent, Unit>,
    onSelectRecipe: (recipeId: Int, netType: NetType)-> Unit
) {

    LaunchedEffect(key1 = true) {
        onTriggerEvent(PostListEvent.LoadPostsNextPage(0));
    }

    val state = mState.collectAsState().value.uiState

    val scrollState = rememberScrollState()
//    val pagerState = rememberPagerState()

    when (state) {
        is UiState.Loading -> {
//            LazyColumn(content = )
            

        }

        is UiState.Failure -> {

        }

        is UiState.Success<List<PostLit>> -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(state.data) { post ->
                    PostCard(post = post)
                }
            }
        }
    }
}