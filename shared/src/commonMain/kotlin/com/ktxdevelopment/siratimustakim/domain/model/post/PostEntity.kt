package com.ktxdevelopment.siratimustakim.domain.model.post

import com.ktxdevelopment.siratimustakim.domain.model.author.AuthorLit
import com.ktxdevelopment.siratimustakim.domain.model.category.Category
import com.ktxdevelopment.siratimustakim.domain.model.tag.Tag
import kotlinx.serialization.Serializable

@Serializable
class PostEntity(
    var id: String,
    var title: String,
    var subtitle: String? = null,
    var tags: String?, // list of tags as json string
    var category: String? = null, // category as json string
    var content: String? = null,
    var author: String? = null, // author id
    var date: String? = null,
    var references: String? = null, //
    var viewed: Long? = 0,
)