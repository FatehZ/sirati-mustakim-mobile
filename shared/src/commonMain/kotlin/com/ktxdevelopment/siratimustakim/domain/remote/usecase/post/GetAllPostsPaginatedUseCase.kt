package com.ktxdevelopment.siratimustakim.domain.remote.usecase.post

import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.remote.repository.PostRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetAllPostsPaginatedUseCase: KoinComponent {
    private val repository: PostRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(page: Int): List<PostLit> {
        return repository.getAllPosts(page)
    }
}