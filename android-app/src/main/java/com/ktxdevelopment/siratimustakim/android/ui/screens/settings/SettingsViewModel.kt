package com.ktxdevelopment.siratimustakim.android.ui.activity.settings

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ktxdevelopment.siratimustakim.domain.local.usecase.CheckPostSavedLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.local.usecase.SavePostLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.local.usecase.DeletePostLocalUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SettingsViewModel(
    private val isPostSavedLocally: CheckPostSavedLocalUsecase,
    private val savePostLocalUsecase: SavePostLocalUsecase,
    private val deletePostLocalUsecase: DeletePostLocalUsecase,
    application: Application) : AndroidViewModel(application) {

    public var state by mutableStateOf(SettingsScreenState())
        private set


    fun savePost() {
      saveStateChangingUI()
        state.post.let {
            viewModelScope.launch(Dispatchers.IO) {
                savePostLocalUsecase.invoke(post = it!!)
            }
        }
    }

    fun unsavePost() {
        saveStateChangingUI()
        state.post?.let {
            viewModelScope.launch(Dispatchers.IO) {
                deletePostLocalUsecase.invoke(id = it.id!!)
            }
        }
    }

    private fun saveStateChangingUI() {
        state = state.copy(postSavedState = SettingsSavedState.LOADING)
    }
}