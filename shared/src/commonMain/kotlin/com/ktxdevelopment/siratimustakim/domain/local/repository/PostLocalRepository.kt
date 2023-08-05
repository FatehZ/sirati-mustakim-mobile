package com.ktxdevelopment.siratimustakim.domain.local.repository

import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit

internal interface PostLocalRepository {

    suspend fun getAllPosts(page: Int): List<PostLit>

    suspend fun getPostById(id: String): Post

    suspend fun search(query: String): List<PostLit>

    suspend fun insertPost(post: Post)

    suspend fun deletePost(id: String)
}