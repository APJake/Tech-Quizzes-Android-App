package com.apjake.techquizzes.domain.model

import com.apjake.techquizzes.data.network.dto.AnswersDto
import com.apjake.techquizzes.data.network.dto.CorrectAnswersDto
import com.google.gson.annotations.SerializedName

class QuizAndAnswer(
    val id: Int,
    val answers: Answers,
    val category: String,
    val correctAnswers: Answers,
    val description: String,
    val difficulty: String,
    val explanation: String,
    val multipleCorrectAnswers: Boolean,
    val question: String,
    val tags: List<String>
)