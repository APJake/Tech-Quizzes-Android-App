package com.apjake.techquizzes.domain.repository

import com.apjake.techquizzes.domain.model.QuizAndAnswer
import com.apjake.techquizzes.domain.model.QuizHeader
import com.apjake.techquizzes.util.Resource
import kotlinx.coroutines.flow.Flow

interface QuizRepository {
    fun getQuizzes(header: QuizHeader): Flow<Resource<List<QuizAndAnswer>>>
}