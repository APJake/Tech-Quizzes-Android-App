package com.apjake.techquizzes.data.network.datasource

import com.apjake.techquizzes.data.datasource.QuizHeadersNetworkDataSource
import com.apjake.techquizzes.data.network.api.PrivateApi
import com.apjake.techquizzes.data.network.mapper.QuizHeaderDtoMapper
import com.apjake.techquizzes.domain.model.QuizHeader

class QuizHeadersNetworkDataSourceImpl(
    private val api: PrivateApi
): QuizHeadersNetworkDataSource {
    private val quizHeaderMapper = QuizHeaderDtoMapper()
    override suspend fun getQuizHeaders(): List<QuizHeader> {
        return api.getQuizHeaders().map { quizHeaderMapper.map(it) }
    }
}