package com.apjake.techquizzes.data.network.dto


import com.google.gson.annotations.SerializedName

data class CorrectAnswersDto(
    @SerializedName("answer_a_correct")
    val answerACorrect: String?,
    @SerializedName("answer_b_correct")
    val answerBCorrect: String?,
    @SerializedName("answer_c_correct")
    val answerCCorrect: String?,
    @SerializedName("answer_d_correct")
    val answerDCorrect: String?,
    @SerializedName("answer_e_correct")
    val answerECorrect: String?,
    @SerializedName("answer_f_correct")
    val answerFCorrect: String?
)