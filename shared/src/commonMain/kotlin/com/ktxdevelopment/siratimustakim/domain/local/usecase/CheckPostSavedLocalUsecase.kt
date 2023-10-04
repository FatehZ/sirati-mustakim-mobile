package com.ktxdevelopment.siratimustakim.domain.local.usecase

import com.ktxdevelopment.siratimustakim.domain.local.repository.PostLocalRepository
import com.ktxdevelopment.siratimustakim.domain.model.util.Resource
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CheckPostSavedLocalUsecase : KoinComponent {
    private val repository: PostLocalRepository by inject()

    suspend operator fun invoke(id: String) : Flow<Resource<Boolean>> {
        return repository.isPostSaved(id)
    }
}