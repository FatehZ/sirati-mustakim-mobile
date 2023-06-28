package com.ktxdevelopment.siratimustakim.data.remote.services

import com.ktxdevelopment.siratimustakim.data.remote.ktor.KtorApi
import com.ktxdevelopment.siratimustakim.domain.model.category.Category
import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class CategoryService : KtorApi() {

    suspend fun getCategoryById(categoryId: String) : Category = client.get {
        pathUrl("categories/${categoryId}")
    }.body()

    suspend fun getAllCategories() : List<Category> = client.get {
        pathUrl("categories")
    }.body()
}