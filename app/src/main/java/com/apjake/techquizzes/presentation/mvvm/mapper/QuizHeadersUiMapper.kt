package com.apjake.techquizzes.presentation.mvvm.mapper

import com.apjake.techquizzes.domain.model.QuizHeader
import com.apjake.techquizzes.presentation.mvvm.model.CategorizedQuizHeadersUiModel
import com.apjake.techquizzes.presentation.mvvm.model.QuizHeaderUiModel
import com.apjake.techquizzes.util.UniMapper

class QuizHeadersUiMapper: UniMapper<List<QuizHeader>, List<CategorizedQuizHeadersUiModel>> {
    override fun map(data: List<QuizHeader>): List<CategorizedQuizHeadersUiModel> {
        return data.groupBy {
            it.subtitle
        }.map { map ->
            CategorizedQuizHeadersUiModel(
                title = map.key,
                quizzes = map.value.map {
                    QuizHeaderUiModel(
                        title = it.title,
                        category = it.category,
                        totalQuiz = it.totalQuiz,
                        difficulty = it.difficulty,
                        tags = it.tags,
                        posterUrl = it.posterUrl
                    )
                }
            )
        }
    }
}