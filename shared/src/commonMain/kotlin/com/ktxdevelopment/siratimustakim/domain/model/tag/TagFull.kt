package com.ktxdevelopment.siratimustakim.domain.model.tag

import com.ktxdevelopment.siratimustakim.domain.model.post.Post

data class TagFull(
    val tagId: String,
    val title: String,
    val posts: ArrayList<Post>,
    val description: String
)
