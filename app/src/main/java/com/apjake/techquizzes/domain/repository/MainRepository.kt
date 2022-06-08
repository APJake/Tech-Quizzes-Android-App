package com.apjake.techquizzes.domain.repository

import com.apjake.techquizzes.domain.model.QuizHeader
import com.apjake.techquizzes.domain.model.UserProfile
import com.apjake.techquizzes.util.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getQuizTitles(): Flow<Resource<List<QuizHeader>>>

    suspend fun getUserProfile(): UserProfile?
    suspend fun isRegistered(): Boolean
}