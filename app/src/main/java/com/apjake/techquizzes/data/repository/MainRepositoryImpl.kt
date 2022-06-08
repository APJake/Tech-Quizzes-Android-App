package com.apjake.techquizzes.data.repository

import com.apjake.techquizzes.data.datasource.MainDataStoreDataSource
import com.apjake.techquizzes.data.datasource.QuizHeadersNetworkDataSource
import com.apjake.techquizzes.data.network.HttpStatusCode
import com.apjake.techquizzes.domain.model.QuizHeader
import com.apjake.techquizzes.domain.model.UserProfile
import com.apjake.techquizzes.domain.repository.MainRepository
import com.apjake.techquizzes.util.*
import com.apjake.techquizzes.util.AppConstants.KEY_USER_NAME
import com.apjake.techquizzes.util.AppConstants.KEY_USER_POINTS
import com.apjake.techquizzes.util.AppConstants.KEY_USER_RANK
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MainRepositoryImpl(
    private val networkDataSource: QuizHeadersNetworkDataSource,
    private val dataStoreDataSource: MainDataStoreDataSource
): MainRepository {
    override suspend fun getUserProfile(): UserProfile? {
        val name = dataStoreDataSource.getString(KEY_USER_NAME)
        val rank = dataStoreDataSource.getInt(KEY_USER_RANK)
        val points = dataStoreDataSource.getInt(KEY_USER_POINTS)
        val shortName = name.toShortName()
        if(name.isNullOrBlank() || points == null || rank == null){
            return null
        }
        return UserProfile(
            name = name,
            shortName = shortName,
            points = points,
            rank = rank
        )
    }

    override suspend fun isRegistered(): Boolean {
        return getUserProfile()!=null
    }

    override fun getQuizTitles(): Flow<Resource<List<QuizHeader>>> = flow{
        emit(Resource.Loading())
        try {
            emit(Resource.Success(networkDataSource.getQuizHeaders()))
        }catch (e: HttpException){
            emit(Resource.Error(HttpStatusCode.toMessage(e.code())))
        }catch (e: IOException){
            emit(Resource.Error("Please check your internet connection!"))
        }
    }
}