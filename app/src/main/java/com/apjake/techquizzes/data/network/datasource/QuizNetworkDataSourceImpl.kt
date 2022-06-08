package com.apjake.techquizzes.data.network.datasource

import com.apjake.techquizzes.data.datasource.QuizNetworkDataSource
import com.apjake.techquizzes.data.network.api.QuizApi
import com.apjake.techquizzes.data.network.mapper.QuizDtoMapper
import com.apjake.techquizzes.domain.model.QuizAndAnswer
import com.apjake.techquizzes.util.ifEmptyNull
import com.apjake.techquizzes.util.ifMinusOneNull

class QuizNetworkDataSourceImpl(
    private val api: QuizApi
): QuizNetworkDataSource {
    private val quizMapper = QuizDtoMapper()
    override suspend fun getQuizzes(
        category: String,
        limit: Int,
        difficulty: String
    ): List<QuizAndAnswer> {
        return api.getQuizzes(
            category = category.ifEmptyNull(),
            limit = limit.ifMinusOneNull(),
            difficulty = difficulty.ifEmptyNull()
        ).map {  quizMapper.map(it) }
    }
}