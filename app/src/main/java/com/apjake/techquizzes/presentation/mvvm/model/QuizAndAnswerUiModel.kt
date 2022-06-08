package com.apjake.techquizzes.presentation.mvvm.model

class QuizAndAnswerUiModel(
    val id: Int,
    val answers: AnswersUiModel,
    val category: String,
    val correctAnswers: AnswersUiModel,
    val description: String,
    val difficulty: String,
    val explanation: String,
    val multipleCorrectAnswers: Boolean,
    val question: String,
    val tags: List<String>,
)