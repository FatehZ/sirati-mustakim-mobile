package com.ktxdevelopment.siratimustakim.domain.usecase.post

import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.repository.PostRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetPostByIdUseCase: KoinComponent {
    private val repository: PostRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(id: String): Post{
        return repository.getPostById(id)
    }
}