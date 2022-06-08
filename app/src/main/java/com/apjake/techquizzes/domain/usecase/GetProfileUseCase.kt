package com.apjake.techquizzes.domain.usecase

import com.apjake.techquizzes.domain.repository.MainRepository

class GetProfileUseCase(
    private val repository: MainRepository
) {
    suspend operator fun invoke() = repository.getUserProfile()
}