package com.ktxdevelopment.siratimustakim.data.repository

import com.ktxdevelopment.siratimustakim.data.remote.datasource.TagDataSource
import com.ktxdevelopment.siratimustakim.domain.model.tag.Tag
import com.ktxdevelopment.siratimustakim.domain.repository.TagRepository

internal class TagRepositoryImpl(private val remoteDataSource: TagDataSource) : TagRepository {
    override suspend fun getTagById(tagId: String): Tag {
        return remoteDataSource.getTagById(tagId)
    }

    override suspend fun getAllTags(): List<Tag> {
        return remoteDataSource.getAllTags()
    }
}