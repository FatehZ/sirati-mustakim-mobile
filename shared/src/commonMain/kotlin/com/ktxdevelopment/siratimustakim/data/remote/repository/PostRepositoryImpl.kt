package com.ktxdevelopment.siratimustakim.data.remote.repository

import com.ktxdevelopment.siratimustakim.data.remote.datasource.PostDataSource
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit

internal class PostRepositoryImpl(private val remoteDateSource: PostDataSource): PostRepository {  //setup localDataSource
    override suspend fun getAllPosts(page: Int): List<PostLit> = remoteDateSource.getAllPosts(page)

    override suspend fun getPostById(id: String): Post = remoteDateSource.getPost(id)

    override suspend fun getPostsByCategoryId(categoryId: String): List<PostLit> = remoteDateSource.getPostsByCategoryId(categoryId)
    override suspend fun search(query: String): List<PostLit> = remoteDateSource.search(query)
}