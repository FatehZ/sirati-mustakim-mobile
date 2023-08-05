package com.ktxdevelopment.siratimustakim.domain.model.category

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val categoryId: String,
    val title: String,
    val subtitle: String
)
