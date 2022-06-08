package com.apjake.techquizzes.data.network.dto


import com.google.gson.annotations.SerializedName

data class QuizDto(
    @SerializedName("answers")
    val answers: AnswersDto?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("correct_answers")
    val correctAnswers: CorrectAnswersDto?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("difficulty")
    val difficulty: String?,
    @SerializedName("explanation")
    val explanation: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("multiple_correct_answers")
    val multipleCorrectAnswers: String?,
    @SerializedName("question")
    val question: String?,
    @SerializedName("tags")
    val tags: List<TagDto>?,
    @SerializedName("tip")
    val tip: Any?
)