package com.ktxdevelopment.siratimustakim.data.local.repository

import com.ktxdevelopment.siratimustakim.data.local.datasource.PostDataSource
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.local.repository.PostLocalRepository

internal class PostLocalRepositoryImpl(private val localDateSource: PostDataSource): PostLocalRepository {  //setup localDataSource

    override suspend fun getAllPosts(page: Int): List<PostLit> = localDateSource.getAllPosts(page)

    override suspend fun getPostById(id: String): Post = localDateSource.getPostById(id)

    override suspend fun search(query: String): List<PostLit> = localDateSource.search(query)

    override suspend fun insertPost(post: Post) = localDateSource.insertPost(post)

    override suspend fun deletePost(id: String) = localDateSource.deletePost(id)
}