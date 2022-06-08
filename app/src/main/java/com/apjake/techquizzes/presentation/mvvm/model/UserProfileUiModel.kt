package com.apjake.techquizzes.presentation.mvvm.model

data class UserProfileUiModel(
    val name: String,
    val shortName: String,
    val points: Int,
    val rank: Int,
)