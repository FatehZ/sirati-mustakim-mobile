package com.ktxdevelopment.siratimustakim.data.remote.repository

import com.ktxdevelopment.siratimustakim.data.remote.services.TagService
import com.ktxdevelopment.siratimustakim.domain.model.tag.Tag
import com.ktxdevelopment.siratimustakim.domain.remote.repository.TagRepository

internal class TagRepositoryImpl(private val remoteDataSource: TagService) : TagRepository {
    override suspend fun getTagById(tagId: String): Tag {
        return remoteDataSource.getTagById(tagId)
    }

    override suspend fun getAllTags(): List<Tag> {
        return remoteDataSource.getAllTags()
    }
}