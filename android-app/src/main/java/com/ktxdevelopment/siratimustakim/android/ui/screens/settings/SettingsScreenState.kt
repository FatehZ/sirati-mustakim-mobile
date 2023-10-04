package com.ktxdevelopment.siratimustakim.android.ui.activity.settings

import com.ktxdevelopment.siratimustakim.domain.model.post.Post

data class SettingsScreenState(
    var events : SettingsScreenEvents? = null,
    var post: Post? = null,
    var postSavedState: SettingsSavedState = SettingsSavedState.LOADING
)

data class SettingsScreenEvents(
    val savePostEvent: (() -> Unit)? = null,
    val deletePostEvent: (() -> Unit)? = null
)

enum class SettingsSavedState{
    SAVED, UNSAVED, LOADING
}