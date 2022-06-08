package com.apjake.techquizzes.data.network.dto


import com.google.gson.annotations.SerializedName

data class QuizHeaderDto(
    @SerializedName("category")
    val category: String?,
    @SerializedName("difficulty")
    val difficulty: String?,
    @SerializedName("poster")
    val poster: String?,
    @SerializedName("subtitle")
    val subtitle: String?,
    @SerializedName("tags")
    val tags: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("totalQuiz")
    val totalQuiz: Int?
)