package com.ktxdevelopment.siratimustakim.data.local.datasource

import com.ktxdevelopment.siratimustakim.data.local.services.PostLocalService
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.util.Dispatcher
import kotlinx.coroutines.withContext

//internal class PostDataSource(
//    private val postLocalService: PostLocalService,
//    private val dispatcher: Dispatcher
//) {
//
//    suspend fun getAllPosts(page: Int) = withContext(dispatcher.io){
//        postLocalService.getAllPostsPaginated(page = page)
//    }
//
//    suspend fun getPostById(id: String) = withContext(dispatcher.io){
//        postLocalService.getPostById(id = id)
//    }
//
//    suspend fun insertPost(post: Post) = withContext(dispatcher.io) {
//        postLocalService.insertPost(post)
//    }
//
//    suspend fun search(query: String)  = withContext(dispatcher.io) {
//        postLocalService.searchInPosts(query)
//    }
//
//    suspend fun deletePost(id: String) = withContext(dispatcher.io) {
//        postLocalService.deletePostById(id)
//    }
//
//    suspend fun isPostSaved(id: String) = withContext(dispatcher.io) {
//        postLocalService.isPostSaved(id)
//    }
//}

