package com.ktxdevelopment.siratimustakim.android.ui.screens.home

import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit

data class HomeScreenState(
    private val posts: List<PostLit>? = null,
    private val events: (() -> Unit)? = null
)