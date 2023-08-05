package com.ktxdevelopment.siratimustakim.domain.remote.repository

import com.ktxdevelopment.siratimustakim.domain.model.category.Category
import com.ktxdevelopment.siratimustakim.domain.model.category.CategoryFull

interface CategoryRepository {

    suspend fun getCategoryById(categoryId: String) : Category

    suspend fun getAllCategories() : List<Category>
}