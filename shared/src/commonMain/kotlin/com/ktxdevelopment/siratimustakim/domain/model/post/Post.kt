package com.ktxdevelopment.siratimustakim.domain.model.post

import com.ktxdevelopment.siratimustakim.domain.model.author.AuthorLink
import com.ktxdevelopment.siratimustakim.domain.model.category.Category
import com.ktxdevelopment.siratimustakim.domain.model.post.node.Node
import com.ktxdevelopment.siratimustakim.domain.model.tag.Tag

data class Post (
    var title: String,
    var subtitle: String,
    var tagIds: ArrayList<Tag>,
    var category: Category,
    var content: ArrayList<Node>,
    var authors: ArrayList<AuthorLink>,
    var references: ArrayList<String>?,
    var viewed: Long
)