package com.ktxdevelopment.siratimustakim.domain.repository

import com.ktxdevelopment.siratimustakim.domain.model.category.Category
import com.ktxdevelopment.siratimustakim.domain.model.category.CategoryFull
import com.ktxdevelopment.siratimustakim.domain.model.tag.Tag
import com.ktxdevelopment.siratimustakim.domain.model.tag.TagFull

interface TagRepository {
    suspend fun getTagById(tagId: String) : Tag

    suspend fun getAllTags() : List<Tag>
}