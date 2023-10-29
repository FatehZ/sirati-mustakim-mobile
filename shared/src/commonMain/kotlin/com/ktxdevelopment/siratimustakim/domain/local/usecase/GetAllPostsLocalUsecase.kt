package com.ktxdevelopment.siratimustakim.domain.local.usecase

import com.ktxdevelopment.siratimustakim.domain.local.repository.PostLocalRepository
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetAllPostsLocalUsecase: KoinComponent {
    private val repository: PostLocalRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(): Flow<Resource<List<PostLit>>> {
        return repository.getAllPosts()
    }
}