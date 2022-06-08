package com.apjake.techquizzes.data.datasource

interface MainDataStoreDataSource {
    suspend fun saveString(key: String, value: String)
    suspend fun getString(key: String): String?

    suspend fun saveInt(key: String, value: Int)
    suspend fun getInt(key: String): Int?

    suspend fun saveLong(key: String, value: Long)
    suspend fun getLong(key: String): Long?

    suspend fun saveDouble(key: String, value: Double)
    suspend fun getDouble(key: String): Double?
}