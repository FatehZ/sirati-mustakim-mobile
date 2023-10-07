package com.ktxdevelopment.siratimustakim.android.ui.screens.postlist

import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit

data class PostListScreenState(
    private val posts: List<PostLit>? = null,
    private val events: (() -> Unit)? = null
)