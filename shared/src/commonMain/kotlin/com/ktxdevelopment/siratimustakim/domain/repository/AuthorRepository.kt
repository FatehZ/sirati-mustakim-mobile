package com.ktxdevelopment.siratimustakim.domain.repository

import com.ktxdevelopment.siratimustakim.domain.model.author.Author
import com.ktxdevelopment.siratimustakim.domain.model.author.AuthorLink

interface AuthorRepository {

    suspend fun getAuthorInfoById(userId: String) : Author
}