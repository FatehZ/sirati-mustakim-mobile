package com.ktxdevelopment.siratimustakim.android.ui.activity.post

import com.ktxdevelopment.siratimustakim.domain.model.post.Post

data class PostDetailScreenState(
    var events : PostDetailScreenEvents? = null,
    var post: Post? = null,
    var postSavedState: PostDetailSavedState = PostDetailSavedState.LOADING
)

data class PostDetailScreenEvents(
    val savePostEvent: (() -> Unit)? = null,
    val deletePostEvent: (() -> Unit)? = null
)

enum class PostDetailSavedState{
    SAVED, UNSAVED, LOADING
}