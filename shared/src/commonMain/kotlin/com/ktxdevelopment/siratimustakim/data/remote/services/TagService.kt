package com.ktxdevelopment.siratimustakim.data.remote.services

import com.ktxdevelopment.siratimustakim.data.remote.ktor.KtorApi
import com.ktxdevelopment.siratimustakim.domain.model.category.Category
import com.ktxdevelopment.siratimustakim.domain.model.tag.Tag
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class TagService : KtorApi() {
    suspend fun getTagById(tagId: String) : Tag = client.get {
        pathUrl("tags/${tagId}")
    }.body()

    suspend fun getAllTags() : List<Tag> = client.get {
        pathUrl("tags")
    }.body()
}