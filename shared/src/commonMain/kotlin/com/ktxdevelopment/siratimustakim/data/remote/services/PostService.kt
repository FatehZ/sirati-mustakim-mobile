package com.ktxdevelopment.siratimustakim.data.remote.services

import com.ktxdevelopment.siratimustakim.data.remote.ktor.KtorApi
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class PostService: KtorApi() {

    suspend fun getPostById(postId: String) : Post = client.get {
        pathUrl("posts/${postId}")
    }.body()

    suspend fun getAllPostsPaginated(page: Int, limit: Int = 20): List<PostLit> = client.get {
        pathUrl("posts") //todo check again from backend
        parameter("p", page)
        parameter("l", limit)
    }.body()

    suspend fun getPostsByCategoryId(categoryId: String): List<PostLit> = client.get {
        pathUrl("categories/${categoryId}/posts")
    }.body()

    suspend fun getPostsByTagId(tagId: String): List<PostLit> = client.get {
        pathUrl("tags/${tagId}/posts")
    }.body()

    suspend fun searchInPosts(query: String) : List<PostLit> = client.get {
        pathUrl("search/post")
        parameter("q", query)
    }.body()
}