package com.ktxdevelopment.siratimustakim.data.local.datasource

import com.ktxdevelopment.siratimustakim.data.local.services.PostService
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.util.Dispatcher
import kotlinx.coroutines.withContext

internal class PostDataSource(
    private val postService: PostService,
    private val dispatcher: Dispatcher
) {

    suspend fun getAllPosts(page: Int) = withContext(dispatcher.io){
        postService.getAllPostsPaginated(page = page)
    }

    suspend fun getPostById(id: String) = withContext(dispatcher.io){
        postService.getPostById(id = id)
    }

    suspend fun insertPost(post: Post) = withContext(dispatcher.io) {
        postService.insertPost(post)
    }

    suspend fun search(query: String)  = withContext(dispatcher.io) {
        postService.searchInPosts(query)
    }

    fun deletePost(id: String) {
        postService.deletePostById(id)
    }
}