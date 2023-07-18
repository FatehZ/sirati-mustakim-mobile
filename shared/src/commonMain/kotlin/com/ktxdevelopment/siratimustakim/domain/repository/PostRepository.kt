package com.ktxdevelopment.siratimustakim.domain.repository

import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit

internal interface PostRepository {

    suspend fun getAllPosts(page: Int): List<PostLit>

    suspend fun getPostById(postId: String): Post

    suspend fun getPostsByCategoryId(categoryId: String) : List<PostLit>

    suspend fun search(query: String): List<PostLit>
}