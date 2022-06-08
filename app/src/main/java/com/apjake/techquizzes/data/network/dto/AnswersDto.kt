package com.apjake.techquizzes.data.network.dto


import com.google.gson.annotations.SerializedName

data class AnswersDto(
    @SerializedName("answer_a")
    val answerA: String?,
    @SerializedName("answer_b")
    val answerB: String?,
    @SerializedName("answer_c")
    val answerC: String?,
    @SerializedName("answer_d")
    val answerD: String?,
    @SerializedName("answer_e")
    val answerE: String?,
    @SerializedName("answer_f")
    val answerF: String?
)