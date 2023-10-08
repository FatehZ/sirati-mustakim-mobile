package com.ktxdevelopment.siratimustakim.android.ui.screens.postlist

import com.ktxdevelopment.siratimustakim.android.util.UiState
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit

data class PostListScreenState(
    val uiState: UiState<List<PostLit>>? = null
)