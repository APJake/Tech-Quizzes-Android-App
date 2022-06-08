package com.apjake.techquizzes.data.network.api

import com.apjake.techquizzes.data.network.dto.QuizDto
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizApi {
    companion object{
        const val BASE_URL = "https://quizapi.io/"
    }

    @GET("/v1/questions")
    suspend fun getQuizzes(
        @Query("category")
        category: String?,
        @Query("limit")
        limit: Int?,
        @Query("difficulty")
        difficulty: String?
    ): List<QuizDto>
}