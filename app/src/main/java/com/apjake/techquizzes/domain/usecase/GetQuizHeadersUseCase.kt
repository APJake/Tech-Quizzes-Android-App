package com.apjake.techquizzes.domain.usecase

import com.apjake.techquizzes.domain.repository.MainRepository

class GetQuizHeadersUseCase(
    private val repository: MainRepository
) {
    operator fun invoke() = repository.getQuizTitles()
}