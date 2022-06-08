package com.apjake.techquizzes.di

import android.content.Context
import com.apjake.techquizzes.data.datasource.MainDataStoreDataSource
import com.apjake.techquizzes.data.datasource.QuizHeadersNetworkDataSource
import com.apjake.techquizzes.data.datasource.QuizNetworkDataSource
import com.apjake.techquizzes.data.datastore.MainDataStoreDataSourceImpl
import com.apjake.techquizzes.data.network.api.PrivateApi
import com.apjake.techquizzes.data.network.api.QuizApi
import com.apjake.techquizzes.data.network.datasource.QuizHeadersNetworkDataSourceImpl
import com.apjake.techquizzes.data.network.mapper.QuizDtoMapper
import com.apjake.techquizzes.data.network.datasource.QuizNetworkDataSourceImpl
import com.apjake.techquizzes.data.repository.MainRepositoryImpl
import com.apjake.techquizzes.data.repository.QuizRepositoryImpl
import com.apjake.techquizzes.domain.repository.MainRepository
import com.apjake.techquizzes.domain.repository.QuizRepository
import com.apjake.techquizzes.domain.usecase.GetProfileUseCase
import com.apjake.techquizzes.domain.usecase.GetQuizHeadersUseCase
import com.apjake.techquizzes.domain.usecase.GetQuizzesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideQuizNetworkDataSource(
        api: QuizApi
    ): QuizNetworkDataSource = QuizNetworkDataSourceImpl(api)

    @Provides
    @Singleton
    fun provideQuizHeadersNetworkDataSource(
        api: PrivateApi
    ): QuizHeadersNetworkDataSource = QuizHeadersNetworkDataSourceImpl(
        api
    )

    @Provides
    @Singleton
    fun provideMainDataStoreDataSource(
        @ApplicationContext context: Context
    ): MainDataStoreDataSource = MainDataStoreDataSourceImpl(
        context
    )

    @Provides
    @Singleton
    fun provideQuizRepository(
        networkDataSource: QuizNetworkDataSource
    ): QuizRepository = QuizRepositoryImpl(networkDataSource)

    @Provides
    @Singleton
    fun provideGetProfileUseCase(
        repository: MainRepository
    ) = GetProfileUseCase(repository)

    @Provides
    @Singleton
    fun provideGetQuizzesUseCase(
        repository: QuizRepository
    ) = GetQuizzesUseCase(repository)

    @Provides
    @Singleton
    fun provideMainRepository(
        networkDataSource: QuizHeadersNetworkDataSource,
        dataStoreDataSource: MainDataStoreDataSource
    ): MainRepository = MainRepositoryImpl(
        networkDataSource,
        dataStoreDataSource
    )

    @Provides
    @Singleton
    fun provideGetQuizHeadersUseCase(
        repository: MainRepository
    ) = GetQuizHeadersUseCase(repository)

    @Provides
    @Singleton
    fun provideQuizApi(): QuizApi {
        return Retrofit.Builder()
            .baseUrl(QuizApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuizApi::class.java)
    }

    @Provides
    @Singleton
    fun providePrivateApi(): PrivateApi {
        return Retrofit.Builder()
            .baseUrl(PrivateApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PrivateApi::class.java)
    }

}