package com.apjake.techquizzes.data.datasource

import com.apjake.techquizzes.domain.model.QuizHeader

interface QuizHeadersNetworkDataSource {
    suspend fun getQuizHeaders(): List<QuizHeader>
}