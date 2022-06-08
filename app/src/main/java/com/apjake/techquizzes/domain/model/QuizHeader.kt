package com.apjake.techquizzes.domain.model

data class QuizHeader(
    val title: String,
    val category: String,
    val subtitle: String,
    val totalQuiz: Int,
    val difficulty: String,
    val tags: String,
    val posterUrl: String,
)