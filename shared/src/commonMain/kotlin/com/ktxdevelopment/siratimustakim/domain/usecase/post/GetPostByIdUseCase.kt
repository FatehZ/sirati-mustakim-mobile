package com.ktxdevelopment.siratimustakim.domain.usecase.post

import com.ktxdevelopment.siratimustakim.domain.repository.PostRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetPostByIdUseCase: KoinComponent {
    private val repository: PostRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(page: Int): List<Movie>{
        return repository.getAllPosts(page = page)
    }
}