package com.ktxdevelopment.siratimustakim.android.ui.screens.postlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.post.GetAllPostsPaginatedUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class PostListViewModel(
    application: Application,
//    private val searchPostsUseCase: SearchPostsUseCase,
    private val getAllPostsUseCase: GetAllPostsPaginatedUseCase
) : AndroidViewModel(application) {



    val state: MutableStateFlow<PostListScreenState> = MutableStateFlow(PostListScreenState())
    private var getPostsJob: Job? = null

    init { getPostsRemote(0) }

    fun onTriggerEvent(event: PostListEvent) {
        when (event) {
            is PostListEvent.LoadPostsNextPage -> {
                getPostsRemote(event.page)
            }
        }
    }

    private fun getPostsRemote(page: Int) {
        getPostsJob?.cancel()
        viewModelScope.launch {
            getPostsJob = getAllPostsUseCase.invoke(page).onEach { result ->
                when(result) {
                    is Resource.Success -> state.value = state.value.copy(posts = result.data)
                    is Resource.Failure -> Unit //todo
                }
            }.launchIn(this)
        }
    }
}