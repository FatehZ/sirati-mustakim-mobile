package com.ktxdevelopment.siratimustakim.android.ui.screens.postdetail

import com.ktxdevelopment.siratimustakim.android.util.NetType
import com.ktxdevelopment.siratimustakim.android.util.UiState
import com.ktxdevelopment.siratimustakim.domain.model.post.Post

data class PostDetailScreenState(
    var events : PostDetailEvent? = null,
    var uiState: UiState<Post>,
    var savedState: UiState<Boolean>,
    var dataType: DataType? = null,
    var postSavedState: PostDetailSavedState = PostDetailSavedState.LOADING
)

enum class DataType{
    LOCAL, REMOTE
}

sealed class PostDetailEvent {
    object SavePostEvent : PostDetailEvent()
    object DeletePostEvent : PostDetailEvent()
    data class GetPostEvent(val postId: String, val netType: NetType) : PostDetailEvent()
}

sealed class HomeEvent {
    //    data class SavePost(val noteOrder: NoteOrder): HomeEvent()
//    data class DeletePost(val post: Post): HomeEvent()
    data class LoadPostsNextPage(val page: Int): HomeEvent()
}

enum class PostDetailSavedState{
    SAVED, UNSAVED, LOADING
}