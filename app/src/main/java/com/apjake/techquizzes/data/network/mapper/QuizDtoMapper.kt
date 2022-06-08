package com.apjake.techquizzes.data.network.mapper

import com.apjake.techquizzes.data.network.dto.QuizDto
import com.apjake.techquizzes.domain.model.Answers
import com.apjake.techquizzes.domain.model.QuizAndAnswer
import com.apjake.techquizzes.util.UniMapper

class QuizDtoMapper: UniMapper<QuizDto, QuizAndAnswer> {
    override fun map(data: QuizDto): QuizAndAnswer {
        return QuizAndAnswer(
            id = data.id?:-1,
            question = data.question.orEmpty(),
            answers = Answers(
                answerA = data.answers?.answerA,
                answerB = data.answers?.answerB,
                answerC = data.answers?.answerC,
                answerD = data.answers?.answerD,
                answerE = data.answers?.answerE,
                answerF = data.answers?.answerF,
            ),
            category = data.category.orEmpty(),
            correctAnswers = Answers(
                answerA = data.correctAnswers?.answerACorrect,
                answerB = data.correctAnswers?.answerBCorrect,
                answerC = data.correctAnswers?.answerCCorrect,
                answerD = data.correctAnswers?.answerDCorrect,
                answerE = data.correctAnswers?.answerECorrect,
                answerF = data.correctAnswers?.answerFCorrect,
            ),
            description = data.description.orEmpty(),
            difficulty = data.difficulty.orEmpty(),
            explanation = data.explanation.orEmpty(),
            multipleCorrectAnswers = data.multipleCorrectAnswers.toBoolean(),
            tags = data.tags.orEmpty().map { it.name }
        )
    }
}