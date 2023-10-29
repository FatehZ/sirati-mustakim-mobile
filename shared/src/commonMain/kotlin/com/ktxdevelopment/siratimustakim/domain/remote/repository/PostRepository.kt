package com.ktxdevelopment.siratimustakim.domain.remote.repository

import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import kotlinx.coroutines.flow.Flow

internal interface PostRepository {

    suspend fun getAllPosts(page: Int): Flow<Resource<List<PostLit>>>

    suspend fun getPostById(id: String): Flow<Resource<Post>>

    suspend fun getPostsByCategoryId(categoryId: String) : Flow<Resource<List<PostLit>>>

    suspend fun getPostsByTagId(tagId: String) : Flow<Resource<List<PostLit>>>

    suspend fun search(query: String): Flow<Resource<List<PostLit>>>
}