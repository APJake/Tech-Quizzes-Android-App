package com.apjake.techquizzes.presentation.mvvm.model

data class CategorizedQuizHeadersUiModel(
    val title: String,
    val quizzes: List<QuizHeaderUiModel>
)