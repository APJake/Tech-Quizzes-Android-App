package com.apjake.techquizzes.data.network.api

import com.apjake.techquizzes.data.network.dto.QuizHeaderDto
import retrofit2.http.GET

interface PrivateApi {
    companion object{
        const val BASE_URL = "https://raw.githubusercontent.com/"
    }
    @GET("/APJake/My-APIs/main/api/quiz-headers.json")
    suspend fun getQuizHeaders(): List<QuizHeaderDto>
}