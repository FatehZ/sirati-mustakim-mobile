package com.ktxdevelopment.siratimustakim.android.ui.screens.postlist

sealed class PostListEvent {
//    data class SavePost(val noteOrder: NoteOrder): HomeEvent()
//    data class DeletePost(val post: Post): HomeEvent()
    data class LoadPostsNextPage(val page: Int): PostListEvent()
    data class LoadPostsLocalNextPage(val page: Int): PostListEvent()
    data class SearchPost(val query: String): PostListEvent()

}