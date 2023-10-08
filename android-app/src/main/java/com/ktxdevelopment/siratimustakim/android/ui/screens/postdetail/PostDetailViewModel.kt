package com.ktxdevelopment.siratimustakim.android.ui.screens.postdetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ktxdevelopment.siratimustakim.android.util.NetType
import com.ktxdevelopment.siratimustakim.android.util.UiState
import com.ktxdevelopment.siratimustakim.domain.local.usecase.CheckPostSavedLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.local.usecase.DeletePostLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.local.usecase.GetPostByIdLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.local.usecase.SavePostLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.post.GetPostByIdUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class PostDetailViewModel(
    private val isPostSavedLocally: CheckPostSavedLocalUsecase,
    private val getPostByIdLocalUsecase: GetPostByIdLocalUsecase,
    private val getPostByIdRemoteUseCase: GetPostByIdUseCase,
    private val savePostLocalUsecase: SavePostLocalUsecase,
    private val deletePostLocalUsecase: DeletePostLocalUsecase,
    application: Application) :     AndroidViewModel(application) {

    var state: MutableStateFlow<PostDetailScreenState> = MutableStateFlow(PostDetailScreenState(uiState = UiState.Loading(), savedState = UiState.Loading()))
        private set

    private var getPostLocalJob: Job? = null
    private var getPostRemoteJob: Job? = null
    private var getPostSavedStateJob: Job? = null


    private fun savePost() {
        saveStateChangingUI()
        viewModelScope.launch {
            if (state.value.uiState is UiState.Success)
                savePostLocalUsecase.invoke(post = (state.value.uiState as UiState.Success<Post>).data)
        }
    }

    private fun getPostSavedState(id: String) {
        getPostSavedStateJob?.cancel()
        viewModelScope.launch {
            getPostLocalJob = isPostSavedLocally.invoke(id).onEach { result ->
                when(result) {
                    is Resource.Success -> state.value = state.value.copy(savedState = UiState.Success(result.data))
                    is Resource.Failure -> state.value = state.value.copy(savedState = UiState.Failure(result.error))
                }
            }.launchIn(this)
        }
    }

    private fun unsavePost() {
        saveStateChangingUI()
        viewModelScope.launch {
            if (state.value.uiState is UiState.Success)
                deletePostLocalUsecase.invoke(id = (state.value.uiState as UiState.Success<Post>).data.id!!)
        }
    }

    private fun saveStateChangingUI() {
        state.value = state.value.copy(savedState = UiState.Loading())
    }

    private fun getPostById(id: String, netType: NetType) {
        if (netType == NetType.LOCAL) getPostByIdLocally(id)
        else getPostByIdRemote(id)
        getPostSavedState(id)
    }

    private fun getPostByIdLocally(id: String) {
        getPostLocalJob?.cancel()
        viewModelScope.launch {
            getPostLocalJob = getPostByIdLocalUsecase.invoke(id).onEach { result ->
                when(result) {
                    is Resource.Success -> state.value = state.value.copy(uiState = UiState.Success(result.data))
                    is Resource.Failure -> state.value = state.value.copy(uiState = UiState.Failure(result.error))
                }
            }.launchIn(this)
        }
    }

    private fun getPostByIdRemote(id: String) {
        getPostRemoteJob?.cancel()
        viewModelScope.launch {
            getPostRemoteJob = getPostByIdRemoteUseCase.invoke(id).onEach { result ->
                when(result) {
                    is Resource.Success -> state.value = state.value.copy(uiState = UiState.Success(result.data))
                    is Resource.Failure -> state.value = state.value.copy(uiState = UiState.Failure(result.error))
                }
            }.launchIn(this)
        }
    }

    fun onTriggerEvent(event: PostDetailEvent) {
        when (event) {
            is PostDetailEvent.SavePostEvent -> savePost()
            is PostDetailEvent.DeletePostEvent -> unsavePost()
            is PostDetailEvent.GetPostEvent -> getPostById(event.postId, event.netType)
        }
    }
}