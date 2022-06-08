package com.apjake.techquizzes.presentation.mvvm.mapper

import com.apjake.techquizzes.domain.model.UserProfile
import com.apjake.techquizzes.presentation.mvvm.model.UserProfileUiModel
import com.apjake.techquizzes.util.UniMapper
import com.apjake.techquizzes.util.orZero

class UserProfileUiMapper: UniMapper<UserProfile, UserProfileUiModel> {
    override fun map(data: UserProfile): UserProfileUiModel {
        return UserProfileUiModel(
                name = data.name,
                shortName = data.shortName,
                points = data.points,
                rank = data.rank,
            )
    }
}