package com.ktxdevelopment.siratimustakim.data.repository

import com.ktxdevelopment.siratimustakim.data.remote.datasource.PostDataSource
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.repository.PostRepository

internal class PostRepositoryImpl(private val remoteDateSource: PostDataSource): PostRepository {  //setup localDataSource
    override suspend fun getAllPosts(page: Int): List<PostLit> = remoteDateSource.getAllPosts(page)

    override suspend fun getPostById(postId: String): Post = remoteDateSource.getPost(postId)

    override suspend fun getPostsByCategoryId(categoryId: String): List<PostLit> = remoteDateSource.getPostsByCategoryId(categoryId)
    override suspend fun search(query: String): List<PostLit> = remoteDateSource.search(query)
}