package com.ktxdevelopment.siratimustakim.domain.model.category

import com.ktxdevelopment.siratimustakim.domain.model.post.Post
import com.ktxdevelopment.siratimustakim.domain.model.post.PostLit

data class CategoryFull(
    val categoryId: String,
    val title: String,
    val posts: ArrayList<PostLit>,
    val description: String
)
