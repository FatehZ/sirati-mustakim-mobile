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

//    suspend fun getPostById(id: String) : Flow<Resource<Post>> = flow {
//
//        try {
//            val response = client.get { pathUrl("posts/${id}") }.body<ApiResponseModel<Post>>()
//            emit(Resource.Success(response.data))
//        } catch (e: Exception) {
//            val result = when (e) {
//                is ServerResponseException -> Resource.Failure(ApiError.ServerError(e.response.status.value, "Server error"))
//                else -> Resource.Failure(ApiError.NetworkError("Network error"))
//            }
//            emit(result)
//        }
//    }



    suspend fun getPostById(id: String) : Flow<Resource<Post>> = flow {
        val result = Resource.Success(Post("wd1", "Main Title", "Subtitle Text that is extensive", null, null,
            content = "<html>\n" +
                    "  <body>\n" +
                    "    <h1>Cinema Classics Movie Reviews</h1>\n" +
                    "    <h2>Review: Basketball Dog (2018)</h2>\n" +
                    "    <p><i>4 out of 5 stars</i></p>\n" +
                    "    <p>From director <b>Vicki Fleming</b> comes the heartwarming tale of a boy named Pete (Trent Dugson) and his dog Rover (voiced by Brinson Lumblebrunt). You may think a boy and his dog learning the true value of friendship sounds familiar, but a big twist sets this flick apart: Rover plays basketball, and he's doggone good at it.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>While it may not have been necessary to include all 150 minutes of Rover's championship game in real time, Basketball Dog will keep your interest for the entirety of its 4-hour runtime, and the end will have any dog lover in tears. If you love basketball or sports pets, this is the movie for you.</p>\n" +
                    "    <p>Find the full cast listing at the Basketball Dog website.</p>\n" +
                    "  </body>\n" +
                    "</html>"
        ))
        emit(result)
    }



    suspend fun getAllPostsPaginatedT(page: Int, limit: Int = 20): Flow<Resource<List<PostLit>>> = flow {
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

    suspend fun getAllPostsPaginated(page: Int, limit: Int = 20): Flow<Resource<List<PostLit>>> = flow {
        val result = Resource.Success(data = arrayListOf(
            PostLit("wd0", "Post Title 1", "Test Post Subtitle Extended Version 1"),
            PostLit("wd1", "Post Title 2", "Test Post Subtitle Extended Version 2"),
            PostLit("wd2", "Post Title 3", "Test Post Subtitle Extended Version 3"),
            PostLit("wd3", "Post Title 4", "Test Post Subtitle Extended Version 4"),
            PostLit("wd4", "Post Title 5", "Test Post Subtitle Extended Version 5"),
            PostLit("wd5", "Post Title 6", "Test Post Subtitle Extended Version 6"),
            PostLit("wd6", "Post Title 7", "Test Post Subtitle Extended Version 7"),
            PostLit("wd7", "Post Title 8", "Test Post Subtitle Extended Version 8"),
            PostLit("wd8", "Post Title 9", "Test Post Subtitle Extended Version 9"),
            PostLit("wd9", "Post Title 10", "Test Post Subtitle Extended Version 10"),
        ))
        emit(result)
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

