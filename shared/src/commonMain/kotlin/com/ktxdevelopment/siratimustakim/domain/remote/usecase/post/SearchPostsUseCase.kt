package com.ktxdevelopment.siratimustakim.domain.remote.usecase.post

import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import com.ktxdevelopment.siratimustakim.domain.remote.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SearchPostsUseCase : KoinComponent {
    private val repo: PostRepository by inject()

    suspend operator fun invoke(query: String): Flow<Resource<List<PostLit>>> {
        return repo.search(query);
    }
}