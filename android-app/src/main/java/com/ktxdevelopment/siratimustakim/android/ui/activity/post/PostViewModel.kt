package com.ktxdevelopment.siratimustakim.android.ui.activity.post

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ktxdevelopment.siratimustakim.domain.local.usecase.SavePostLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.local.usecase.DeletePostLocalUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PostViewModel(
    private val savePostLocalUsecase: SavePostLocalUsecase,
    private val deletePostLocalUsecase: DeletePostLocalUsecase,
    application: Application) : AndroidViewModel(application) {

    var uiState by mutableStateOf(PostScreenState())
        private set


    fun savePost() {
//        disableUI()
        uiState.post.let {
            viewModelScope.launch(Dispatchers.IO) {
                savePostLocalUsecase.invoke(post = it!!)
            }
        }
    }

    fun unsavePost() {
//        disableUI()
        uiState.post.let {
            viewModelScope.launch(Dispatchers.IO) {
                deletePostLocalUsecase.invoke(postId = it!!.id)
            }
        }
    }
}