package com.apjake.techquizzes.data.network.mapper

import com.apjake.techquizzes.data.network.dto.QuizHeaderDto
import com.apjake.techquizzes.domain.model.QuizHeader
import com.apjake.techquizzes.util.UniMapper
import com.apjake.techquizzes.util.orZero

class QuizHeaderDtoMapper: UniMapper<QuizHeaderDto, QuizHeader> {
    override fun map(data: QuizHeaderDto): QuizHeader {
        return QuizHeader(
            title = data.title.orEmpty(),
            category = data.category.orEmpty(),
            subtitle = data.subtitle.orEmpty(),
            totalQuiz = data.totalQuiz.orZero(),
            difficulty = data.difficulty.orEmpty(),
            tags = data.tags.orEmpty(),
            posterUrl = data.poster.orEmpty()
        )
    }
}