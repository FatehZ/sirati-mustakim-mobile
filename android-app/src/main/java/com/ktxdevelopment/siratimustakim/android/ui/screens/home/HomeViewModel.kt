package com.ktxdevelopment.siratimustakim.android.ui.screens.home

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

class HomeViewModel(
    application: Application,
//    private val searchPostsUseCase: SearchPostsUseCase,
    private val getAllPostsUseCase: GetAllPostsPaginatedUseCase
) : AndroidViewModel(application) {



    val state: MutableStateFlow<HomeScreenState> = MutableStateFlow(HomeScreenState())
    private var getPostsJob: Job? = null

    init { getPostsRemote() }

    fun onTriggerEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.LoadPostsNextPage -> {
                getPostsRemote()
            }
        }
    }

    private fun getPostsRemote() {
        getPostsJob?.cancel()
        viewModelScope.launch {
            getPostsJob = getAllPostsUseCase.invoke(20).onEach { result ->
                when(result) {
                    is Resource.Success -> state.value = state.value.copy(posts = result.data)
                    is Resource.Failure -> Unit //todo
                }
            }.launchIn(this)
        }
    }
}