package com.apjake.techquizzes.data.datasource

import com.apjake.techquizzes.domain.model.QuizAndAnswer

interface QuizNetworkDataSource {
    suspend fun getQuizzes(
        category: String,
        limit: Int,
        difficulty: String
    ): List<QuizAndAnswer>
}