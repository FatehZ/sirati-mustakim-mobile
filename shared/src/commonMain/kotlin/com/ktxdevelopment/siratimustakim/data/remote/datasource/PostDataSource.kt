package com.ktxdevelopment.siratimustakim.data.remote.datasource

import com.ktxdevelopment.siratimustakim.data.remote.services.PostService
import com.ktxdevelopment.siratimustakim.util.Dispatcher
import kotlinx.coroutines.withContext

//internal class PostDataSource(
//    private val postService: PostService,
//    private val dispatcher: Dispatcher
//) {
//
//    suspend fun getAllPosts(page: Int) = withContext(dispatcher.io){
//        postService.getAllPostsPaginated(page = page)
//    }
//
//    suspend fun getPost(id: String) = withContext(dispatcher.io){
//        postService.getPostById(id = id)
//    }
//
//    suspend fun getPostsByCategoryId(categoryId: String) = withContext(dispatcher.io){
//        postService.getPostsByCategoryId(categoryId)
//    }
//
//    suspend fun getPostsByTagId(tagId: String) = withContext(dispatcher.io) {
//        postService.getPostsByTagId(tagId)
//    }
//
//    suspend fun search(query: String)  = withContext(dispatcher.io) {
//        postService.searchInPosts(query)
//    }
//}