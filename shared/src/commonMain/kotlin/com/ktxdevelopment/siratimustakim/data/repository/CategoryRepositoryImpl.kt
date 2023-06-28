package com.ktxdevelopment.siratimustakim.data.repository

import com.ktxdevelopment.siratimustakim.data.remote.datasource.CategoryDataSource
import com.ktxdevelopment.siratimustakim.domain.model.category.Category
import com.ktxdevelopment.siratimustakim.domain.repository.CategoryRepository

internal class CategoryRepositoryImpl(private val remoteDataSource: CategoryDataSource) : CategoryRepository {
    override suspend fun getCategoryById(categoryId: String): Category {
        return remoteDataSource.getCategoryById(categoryId)
    }

    override suspend fun getAllCategories(): List<Category> {
        return remoteDataSource.getAllCategories()
    }
}