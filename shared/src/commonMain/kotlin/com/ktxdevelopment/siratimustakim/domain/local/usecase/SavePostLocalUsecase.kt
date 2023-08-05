package com.ktxdevelopment.siratimustakim.domain.local.usecase

import com.ktxdevelopment.siratimustakim.domain.local.repository.PostLocalRepository
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import org.koin.core.component.inject

class SavePostLocalUsecase {

    private val repo: PostLocalRepository by inject()

    suspend operator fun invoke(post: Post) {
        return repo.insertPost(post);
    }
}