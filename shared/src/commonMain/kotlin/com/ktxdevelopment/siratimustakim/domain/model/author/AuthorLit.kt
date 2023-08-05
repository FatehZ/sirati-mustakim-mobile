package com.ktxdevelopment.siratimustakim.domain.model.author

import kotlinx.serialization.Serializable

@Serializable
data class AuthorLit(
    val userId: String,
    val username: String

    //TODO Will change later in collaboration with backend -- now users cant see author
)