package com.apjake.techquizzes.data.repository

import com.apjake.techquizzes.data.datasource.QuizNetworkDataSource
import com.apjake.techquizzes.data.network.HttpStatusCode
import com.apjake.techquizzes.domain.model.QuizAndAnswer
import com.apjake.techquizzes.domain.model.QuizHeader
import com.apjake.techquizzes.domain.repository.QuizRepository
import com.apjake.techquizzes.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class QuizRepositoryImpl(
    private val networkDataSource: QuizNetworkDataSource
): QuizRepository {
    override fun getQuizzes(
        header: QuizHeader
    ): Flow<Resource<List<QuizAndAnswer>>> = flow {
        emit(Resource.Loading())
        try {
            val quizzes = networkDataSource.getQuizzes(
                category = header.category,
                limit = header.totalQuiz,
                difficulty = header.difficulty
            )
            emit(Resource.Success(quizzes))
        }catch (e: HttpException){
            emit(Resource.Error(HttpStatusCode.toMessage(e.code())))
        }catch (e: IOException){
            emit(Resource.Error("Please check your internet connection!"))
        }
    }
}