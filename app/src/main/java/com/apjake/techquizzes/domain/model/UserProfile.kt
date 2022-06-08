package com.apjake.techquizzes.domain.model

data class UserProfile(
    val name: String,
    val shortName: String,
    val points: Int,
    val rank: Int,
)