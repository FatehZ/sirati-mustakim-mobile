package com.ktxdevelopment.siratimustakim.android.ui.screens.post

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ktxdevelopment.siratimustakim.domain.local.usecase.CheckPostSavedLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.local.usecase.DeletePostLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.local.usecase.GetPostByIdLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.local.usecase.SavePostLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.post.GetPostByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class PostDetailViewModel(
    private val isPostSavedLocally: CheckPostSavedLocalUsecase,
    private val getPostByIdLocalUsecase: GetPostByIdLocalUsecase,
    private val getPostByIdUseCase: GetPostByIdUseCase,
    private val savePostLocalUsecase: SavePostLocalUsecase,
    private val deletePostLocalUsecase: DeletePostLocalUsecase,
    application: Application) : AndroidViewModel(application) {

    var state: MutableStateFlow<PostDetailScreenState> = MutableStateFlow(PostDetailScreenState())
        private set


    fun savePost() {
        saveStateChangingUI()
        viewModelScope.launch {
            savePostLocalUsecase.invoke(post = state.value.post!!)
        }
    }

    fun unsavePost() {
        saveStateChangingUI()
            viewModelScope.launch {
                deletePostLocalUsecase.invoke(id = state.value.post!!.id!!)
            }
    }

    private fun saveStateChangingUI() {
        state.value = state.value.copy(postSavedState = PostDetailSavedState.LOADING)
    }

    private fun getPostByIdLocally() {

    }

    fun onTriggerEvent(event: PostDetailScreenEvents) {
        TODO("Not yet implemented")
    }
}