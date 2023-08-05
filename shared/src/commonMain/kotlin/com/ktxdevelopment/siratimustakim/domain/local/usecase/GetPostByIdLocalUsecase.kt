package com.ktxdevelopment.siratimustakim.domain.local.usecase

import com.ktxdevelopment.siratimustakim.domain.local.repository.PostLocalRepository
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetPostByIdLocalUsecase: KoinComponent {
    private val repository: PostLocalRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(id: String): Post{
        return repository.getPostById(id)
    }
}