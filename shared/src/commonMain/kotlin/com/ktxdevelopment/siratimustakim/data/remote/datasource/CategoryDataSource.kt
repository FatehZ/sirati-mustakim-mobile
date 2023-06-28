package com.ktxdevelopment.siratimustakim.data.remote.datasource

import com.ktxdevelopment.siratimustakim.util.Dispatcher
import com.ktxdevelopment.siratimustakim.data.remote.services.CategoryService
import com.ktxdevelopment.siratimustakim.domain.model.category.Category
import kotlinx.coroutines.withContext

internal class CategoryDataSource(
    private val categoryService: CategoryService,
    private val dispatcher: Dispatcher
    ) {

    suspend fun getAllCategories() : List<Category> = withContext(dispatcher.io) {
        categoryService.getAllCategories()
    }

    suspend fun getCategoryById(categoryId: String): Category = withContext(dispatcher.io){
        categoryService.getCategoryById(categoryId)
    }

}