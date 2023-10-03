package com.ktxdevelopment.siratimustakim.data.remote.services

import com.ktxdevelopment.siratimustakim.data.remote.ktor.KtorApi
import com.ktxdevelopment.siratimustakim.data.remote.model.ApiResponseModel
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit
import com.ktxdevelopment.siratimustakim.domain.model.util.ApiError
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import io.ktor.client.call.*
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


internal class PostService: KtorApi() {

    suspend fun getPostById(id: String) : Flow<Resource<Post>> = flow {

        try {
            val response = client.get { pathUrl("posts/${id}") }.body<ApiResponseModel<Post>>()
            emit(Resource.Success(response.data))
        } catch (e: Exception) {
            val result = when (e) {
                is ServerResponseException -> Resource.Failure(ApiError.ServerError(e.response.status.value, "Server error"))
                else -> Resource.Failure(ApiError.NetworkError("Network error"))
            }
            emit(result)
        }
    }

    suspend fun getAllPostsPaginated(page: Int, limit: Int = 20): Flow<Resource<List<PostLit>>> = flow {
        try {
            val response = client.get {
                pathUrl("posts") //todo check again from backend
                parameter("p", page)
                parameter("l", limit)
            }.body<ApiResponseModel<List<PostLit>>>()
            emit(Resource.Success(response.data))
        } catch (e: Exception) {
            val result = when (e) {
                is ServerResponseException -> Resource.Failure(ApiError.ServerError(e.response.status.value, "Server error"))
                else -> Resource.Failure(ApiError.NetworkError("Network error"))
            }
            emit(result)
        }
    }


    suspend fun getPostsByCategoryId(categoryId: String): Flow<Resource<List<PostLit>>> = flow{
        try {
            val response = client.get { pathUrl("categories/${categoryId}/posts") }.body<ApiResponseModel<List<PostLit>>>()
            emit(Resource.Success(response.data))
        } catch (e: Exception) {
            val result = when (e) {
                is ServerResponseException -> Resource.Failure(ApiError.ServerError(e.response.status.value, "Server error"))
                else -> Resource.Failure(ApiError.NetworkError("Network error"))
            }
            emit(result)
        }
    }

    suspend fun getPostsByTagId(tagId: String): Flow<Resource<List<PostLit>>> = flow{
        try {
            val res = client.get { pathUrl("tags/${tagId}/posts") }.body<ApiResponseModel<List<PostLit>>>()
            emit(Resource.Success(res.data))
        } catch (e: Exception) {
            val result = when (e) {
                is ServerResponseException -> Resource.Failure(ApiError.ServerError(e.response.status.value, "Server error"))
                else -> Resource.Failure(ApiError.NetworkError("Network error"))
            }
            emit(result)
        }
    }


    suspend fun searchInPosts(query: String) : Flow<Resource<List<PostLit>>> = flow {

        try {
            val res = client.get {
                pathUrl("search/post")
                parameter("q", query)
            }.body<ApiResponseModel<List<PostLit>>>()
            emit(Resource.Success(res.data))
        } catch (e: Exception) {
            val result = when (e) {
                is ServerResponseException -> Resource.Failure(ApiError.ServerError(e.response.status.value, "Server error"))
                else -> Resource.Failure(ApiError.NetworkError("Network error"))
            }
            emit(result)
        }
    }
}

