package com.ktxdevelopment.siratimustakim.data.remote.datasource

import com.ktxdevelopment.siratimustakim.util.Dispatcher
import com.ktxdevelopment.siratimustakim.data.remote.services.TagService
import com.ktxdevelopment.siratimustakim.domain.model.tag.Tag
import kotlinx.coroutines.withContext

internal class TagDataSource (
    private val tagService: TagService,
    private val dispatcher: Dispatcher
    ) {

    suspend fun getAllTags(): List<Tag> = withContext(dispatcher.io) {
        tagService.getAllTags()
    }

    suspend fun getTagById(categoryId: String): Tag = withContext(dispatcher.io) {
        tagService.getTagById(categoryId)
    }
}
