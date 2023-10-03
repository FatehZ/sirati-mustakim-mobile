package com.ktxdevelopment.siratimustakim.data.remote.repository

import com.ktxdevelopment.siratimustakim.data.remote.services.PostService
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import com.ktxdevelopment.siratimustakim.domain.remote.repository.PostRepository
import com.ktxdevelopment.siratimustakim.util.Dispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

internal class PostRepositoryImpl(private val dispatcher: Dispatcher, private val remoteDateSource: PostService): PostRepository {  //setup localDataSource
    override suspend fun getAllPosts(page: Int): Flow<Resource<List<PostLit>>> = withContext(dispatcher.io) {
        remoteDateSource.getAllPostsPaginated(page)
    }

    override suspend fun getPostById(id: String): Flow<Resource<Post>> = withContext(dispatcher.io) {
        remoteDateSource.getPostById(id)
    }

    override suspend fun getPostsByCategoryId(categoryId: String): Flow<Resource<List<PostLit>>> = withContext(dispatcher.io) {
        remoteDateSource.getPostsByCategoryId(categoryId)
    }

    override suspend fun getPostsByTagId(tagId: String): Flow<Resource<List<PostLit>>> = withContext(dispatcher.io) {
        remoteDateSource.getPostsByTagId(tagId)
    }
    override suspend fun search(query: String): Flow<Resource<List<PostLit>>> = withContext(dispatcher.io) {
        remoteDateSource.searchInPosts(query)
    }
}