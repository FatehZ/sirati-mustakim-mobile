package com.ktxdevelopment.siratimustakim.android.ui.activity.post

import com.ktxdevelopment.siratimustakim.domain.model.post.Post

data class PostScreenState(
    var events : PostScreenEvents? = null,
    var post: Post? = null,
    var isPostSaved: Boolean = false
)

data class PostScreenEvents(
    val savePostEvent: (() -> Unit)? = null,
)