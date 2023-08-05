package com.ktxdevelopment.siratimustakim.android.ui.activity.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.post.GetAllPostsPaginatedUseCase
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.post.SearchPostsUseCase

class HomeViewModel(
    application: Application,
    searchPostsUseCase: SearchPostsUseCase,
    getAllPostsPaginatedUseCase: GetAllPostsPaginatedUseCase
) : AndroidViewModel(application) {

}