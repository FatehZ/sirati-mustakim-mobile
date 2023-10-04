package com.ktxdevelopment.siratimustakim.android.ui.screens.post

import com.ktxdevelopment.siratimustakim.domain.model.post.Post

data class PostDetailScreenState(
    var events : PostDetailScreenEvents? = null,
    var post: Post? = null,
    var dataType: DataType? = null,
    var postSavedState: PostDetailSavedState = PostDetailSavedState.LOADING
)

enum class DataType{
    LOCAL, REMOTE
}

data class PostDetailScreenEvents(
    val savePostEvent: (() -> Unit)? = null,
    val deletePostEvent: (() -> Unit)? = null
)

enum class PostDetailSavedState{
    SAVED, UNSAVED, LOADING
}