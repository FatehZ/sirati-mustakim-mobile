package com.ktxdevelopment.siratimustakim.domain.model.author

import com.ktxdevelopment.siratimustakim.domain.model.util.Stringable

data class Author(
    val userId: String,
    val username: String,
    val image: String,
    val info: String
): Stringable()