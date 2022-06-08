package com.apjake.techquizzes.presentation.mvvm.state

import com.apjake.techquizzes.presentation.mvvm.model.CategorizedQuizHeadersUiModel
import com.apjake.techquizzes.presentation.mvvm.model.UserProfileUiModel

data class HomeUiState(
    val quizLoading: Boolean = false,
    val profileLoading: Boolean = false,
    val profile: UserProfileUiModel? = null,
    val quizList: List<CategorizedQuizHeadersUiModel> = emptyList()
)