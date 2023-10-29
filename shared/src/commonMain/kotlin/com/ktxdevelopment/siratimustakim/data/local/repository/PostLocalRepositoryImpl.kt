package com.ktxdevelopment.siratimustakim.data.local.repository

import com.ktxdevelopment.siratimustakim.data.local.services.PostLocalService
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.local.repository.PostLocalRepository
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import com.ktxdevelopment.siratimustakim.util.Dispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

internal class PostLocalRepositoryImpl(private val dispatcher: Dispatcher, private val localDateSource: PostLocalService): PostLocalRepository {  //setup localDataSource

    override suspend fun getAllPosts(): Flow<Resource<List<PostLit>>> = withContext(dispatcher.io) {
        localDateSource.getAllPostsPaginated()
    }

    override suspend fun getPostById(id: String): Flow<Resource<Post>> = withContext(dispatcher.io) {
        localDateSource.getPostById(id)
    }

    override suspend fun search(query: String): Flow<Resource<List<PostLit>>> = withContext(dispatcher.io) {
        localDateSource.searchInPosts(query)
    }

    override suspend fun insertPost(post: Post) = withContext(dispatcher.io) {
        localDateSource.insertPost(post)
    }

    override suspend fun deletePost(id: String) = withContext(dispatcher.io) {
        localDateSource.deletePostById(id)
    }
    override suspend fun isPostSaved(id: String): Flow<Resource<Boolean>> = withContext(dispatcher.io) {
        localDateSource.isPostSaved(id)
    }
}