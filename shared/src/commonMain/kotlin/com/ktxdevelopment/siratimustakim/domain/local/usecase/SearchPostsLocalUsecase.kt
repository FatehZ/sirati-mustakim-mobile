package com.ktxdevelopment.siratimustakim.domain.local.usecase

import com.ktxdevelopment.siratimustakim.domain.local.repository.PostLocalRepository
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SearchPostsLocalUsecase : KoinComponent {
    private val repo: PostLocalRepository by inject()

    suspend operator fun invoke(query: String): Flow<Resource<List<PostLit>>> {
        return repo.search(query);
    }
}