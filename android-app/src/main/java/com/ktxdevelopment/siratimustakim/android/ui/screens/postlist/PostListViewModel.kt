package com.ktxdevelopment.siratimustakim.android.ui.screens.postlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktxdevelopment.siratimustakim.android.util.UiState
import com.ktxdevelopment.siratimustakim.domain.local.usecase.GetAllPostsLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.post.GetAllPostsPaginatedUseCase
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.post.SearchPostsUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class PostListViewModel(
    private val searchPostsUseCase: SearchPostsUseCase,
    private val getAllPostsUseCase: GetAllPostsPaginatedUseCase,
    private val getAllPostsLocalUsecase: GetAllPostsLocalUsecase
) : ViewModel() {

    val state: MutableStateFlow<PostListScreenState> = MutableStateFlow(PostListScreenState(UiState.Loading()))
    private var getPostsJob: Job? = null

    fun onTriggerEvent(event: PostListEvent) {
        when (event) {
            is PostListEvent.LoadPostsNextPage -> {
                getPostsRemote(event.page)
            }
            is PostListEvent.SearchPost -> {
                searchPostsRemote(event.query)
            }
            is PostListEvent.LoadPostsLocalNextPage -> {
                getPostsLocal()
            }
        }
    }

    private fun getPostsRemote(page: Int) {
        getPostsJob?.cancel()
        viewModelScope.launch {
            getPostsJob = getAllPostsUseCase.invoke(page).onEach { result ->
                when(result) {
                    is Resource.Success -> state.value = state.value.copy(uiState = UiState.Success(result.data))
                    is Resource.Failure -> state.value = state.value.copy(uiState = UiState.Failure(error = result.error))
                }
            }.launchIn(this)
        }
    }

    private fun searchPostsRemote(query: String) {
        getPostsJob?.cancel()
        viewModelScope.launch {
            getPostsJob = searchPostsUseCase.invoke(query).onEach { result ->
                when(result) {
                    is Resource.Success -> state.value = state.value.copy(uiState = UiState.Success(result.data))
                    is Resource.Failure -> state.value = state.value.copy(uiState = UiState.Failure(error = result.error))
                }
            }.launchIn(this)
        }
    }

    private fun getPostsLocal() {
        getPostsJob?.cancel()
        viewModelScope.launch {
            getPostsJob = getAllPostsLocalUsecase.invoke().onEach { result ->
                when(result) {
                    is Resource.Success -> state.value = state.value.copy(uiState = UiState.Success(result.data))
                    is Resource.Failure -> state.value = state.value.copy(uiState = UiState.Failure(error = result.error))
                }
            }.launchIn(this)
        }
    }
}