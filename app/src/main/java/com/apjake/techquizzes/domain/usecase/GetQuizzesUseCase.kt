package com.apjake.techquizzes.domain.usecase

import com.apjake.techquizzes.domain.model.QuizHeader
import com.apjake.techquizzes.domain.repository.QuizRepository

class GetQuizzesUseCase(
    private val quizRepository: QuizRepository
) {
    operator fun invoke(
        header: QuizHeader
    ) = quizRepository.getQuizzes(header)
}