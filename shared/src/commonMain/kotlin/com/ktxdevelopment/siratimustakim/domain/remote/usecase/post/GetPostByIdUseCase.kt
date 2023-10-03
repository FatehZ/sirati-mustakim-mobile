package com.ktxdevelopment.siratimustakim.domain.remote.usecase.post

import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import com.ktxdevelopment.siratimustakim.domain.remote.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetPostByIdUseCase: KoinComponent {
    private val repository: PostRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(id: String): Flow<Resource<Post>> {
        return repository.getPostById(id)
    }
}