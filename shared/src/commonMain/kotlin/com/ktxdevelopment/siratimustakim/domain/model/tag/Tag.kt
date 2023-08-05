package com.ktxdevelopment.siratimustakim.domain.model.tag

import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    val categoryId: String,
    val title: String
)