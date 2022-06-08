package com.apjake.techquizzes.data.network.dto

import com.google.gson.annotations.SerializedName

data class TagDto(
    @SerializedName("name")
    val name: String
)