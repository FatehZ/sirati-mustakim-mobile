package com.ktxdevelopment.siratimustakim.domain.model.post

import com.ktxdevelopment.siratimustakim.domain.model.author.AuthorLit
import com.ktxdevelopment.siratimustakim.domain.model.category.Category
import com.ktxdevelopment.siratimustakim.domain.model.tag.Tag
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    var id: String? = null,
    var title: String? = null,
    var subtitle: String? = null,
    var tags: List<Tag>? = null,
    var category: Category? = null,
    var content: String? = null,
    var author: AuthorLit? = null,
    var date: String? = null,
    var references: List<String>? = null,
    var viewed: Long? = 0,
)