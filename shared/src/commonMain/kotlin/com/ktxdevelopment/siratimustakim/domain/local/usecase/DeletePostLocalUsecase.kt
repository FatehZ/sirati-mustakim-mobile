package com.ktxdevelopment.siratimustakim.domain.local.usecase

import com.ktxdevelopment.siratimustakim.domain.local.repository.PostLocalRepository
import com.ktxdevelopment.siratimustakim.domain.model.post.Post

class DeletePostLocalUsecase {

    private val repo: PostLocalRepository by inject()

    suspend operator fun invoke(id: String) {
        return repo.deletePost(id);
    }

}
