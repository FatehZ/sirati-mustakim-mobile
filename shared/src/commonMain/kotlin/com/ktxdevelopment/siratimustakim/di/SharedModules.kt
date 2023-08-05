package com.ktxdevelopment.siratimustakim.di

import com.ktxdevelopment.siratimustakim.data.local.repository.PostLocalRepositoryImpl
import com.ktxdevelopment.siratimustakim.data.remote.services.PostService
import com.ktxdevelopment.siratimustakim.data.remote.datasource.PostDataSource
import com.ktxdevelopment.siratimustakim.data.remote.repository.PostRepositoryImpl
import com.ktxdevelopment.siratimustakim.domain.remote.repository.PostRepository
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.post.GetAllPostsPaginatedUseCase
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.post.GetPostByIdUseCase
import com.ktxdevelopment.siratimustakim.data.remote.datasource.CategoryDataSource
import com.ktxdevelopment.siratimustakim.data.remote.datasource.TagDataSource
import com.ktxdevelopment.siratimustakim.data.remote.services.CategoryService
import com.ktxdevelopment.siratimustakim.data.remote.services.TagService
import com.ktxdevelopment.siratimustakim.data.remote.repository.CategoryRepositoryImpl
import com.ktxdevelopment.siratimustakim.data.remote.repository.TagRepositoryImpl
import com.ktxdevelopment.siratimustakim.domain.local.usecase.GetAllPostsLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.local.usecase.GetPostByIdLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.local.usecase.SavePostLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.local.usecase.SearchPostsLocalUsecase
import com.ktxdevelopment.siratimustakim.domain.remote.repository.CategoryRepository
import com.ktxdevelopment.siratimustakim.domain.remote.repository.TagRepository
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.category.GetAllCategoriesUseCase
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.category.GetCategoryByIdUseCase
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.post.GetPostsByCategoryIdUseCase
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.post.GetPostsByTagIdUseCase
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.post.SearchPostsUseCase
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.tag.GetAllTagsUseCase
import com.ktxdevelopment.siratimustakim.domain.remote.usecase.tag.GetTagByIdUseCase
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
    single<PostLocalRepository> { PostLocalRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single<TagRepository> { TagRepositoryImpl(get()) }

    factory { GetAllPostsLocalUsecase() }
    factory { GetPostByIdLocalUsecase }
    factory { SavePostLocalUsecase }
    factory { SearchPostsLocalUsecase }

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