package com.ktxdevelopment.siratimustakim.android.ui.screens.home

sealed class HomeEvent {
//    data class SavePost(val noteOrder: NoteOrder): HomeEvent()
//    data class DeletePost(val post: Post): HomeEvent()
    data class LoadPostsNextPage(val page: Int): HomeEvent()
}