package com.ktxdevelopment.siratimustakim.di

import com.ktxdevelopment.siratimustakim.data.remote.services.PostService
import com.ktxdevelopment.siratimustakim.data.remote.datasource.PostDataSource
import com.ktxdevelopment.siratimustakim.data.repository.PostRepositoryImpl
import com.ktxdevelopment.siratimustakim.domain.repository.PostRepository
import com.ktxdevelopment.siratimustakim.domain.usecase.post.GetAllPostsPaginatedUseCase
import com.ktxdevelopment.siratimustakim.domain.usecase.post.GetPostByIdUseCase
import com.ktxdevelopment.siratimustakim.data.remote.datasource.CategoryDataSource
import com.ktxdevelopment.siratimustakim.data.remote.datasource.TagDataSource
import com.ktxdevelopment.siratimustakim.data.remote.services.CategoryService
import com.ktxdevelopment.siratimustakim.data.remote.services.TagService
import com.ktxdevelopment.siratimustakim.data.repository.CategoryRepositoryImpl
import com.ktxdevelopment.siratimustakim.data.repository.TagRepositoryImpl
import com.ktxdevelopment.siratimustakim.domain.repository.CategoryRepository
import com.ktxdevelopment.siratimustakim.domain.repository.TagRepository
import com.ktxdevelopment.siratimustakim.domain.usecase.category.GetAllCategoriesUseCase
import com.ktxdevelopment.siratimustakim.domain.usecase.category.GetCategoryByIdUseCase
import com.ktxdevelopment.siratimustakim.domain.usecase.post.GetPostsByCategoryIdUseCase
import com.ktxdevelopment.siratimustakim.domain.usecase.post.GetPostsByTagIdUseCase
import com.ktxdevelopment.siratimustakim.domain.usecase.post.SearchPostsUseCase
import com.ktxdevelopment.siratimustakim.domain.usecase.tag.GetAllTagsUseCase
import com.ktxdevelopment.siratimustakim.domain.usecase.tag.GetTagByIdUseCase
import com.ktxdevelopment.siratimustakim.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { PostDataSource(get(), get()) }
    factory { TagDataSource(get(), get()) }
    factory { CategoryDataSource(get(), get()) }
    factory { PostService() }
    factory { TagService() }
    factory { CategoryService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<PostRepository> { PostRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single<TagRepository> { TagRepositoryImpl(get()) }
    factory { GetPostByIdUseCase() }
    factory { GetCategoryByIdUseCase() }
    factory { GetAllCategoriesUseCase() }
    factory { GetAllTagsUseCase() }
    factory { GetTagByIdUseCase() }
    factory { GetPostsByCategoryIdUseCase() }
    factory { GetPostsByTagIdUseCase() }
    factory { GetAllPostsPaginatedUseCase() }
    factory { SearchPostsUseCase() }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModules