package com.ktxdevelopment.siratimustakim.domain.local.repository

import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import kotlinx.coroutines.flow.Flow

internal interface PostLocalRepository {

    suspend fun getAllPosts(): Flow<Resource<List<PostLit>>>

    suspend fun getPostById(id: String): Flow<Resource<Post>>

    suspend fun search(query: String): Flow<Resource<List<PostLit>>>

    suspend fun insertPost(post: Post): Flow<Resource<Nothing?>>

    suspend fun deletePost(id: String): Flow<Resource<Nothing?>>

    suspend fun isPostSaved(id: String) : Flow<Resource<Boolean>>
}