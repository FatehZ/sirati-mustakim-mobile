package com.ktxdevelopment.siratimustakim.domain.remote.repository

import com.ktxdevelopment.siratimustakim.domain.model.author.Author

interface AuthorRepository {

    suspend fun getAuthorInfoById(userId: String) : Author
}