package com.ktxdevelopment.siratimustakim.domain.model.post

import kotlinx.serialization.Serializable

@Serializable
data class PostLit (
    val id: String,
    val title: String,
    val subtitle: String
)
