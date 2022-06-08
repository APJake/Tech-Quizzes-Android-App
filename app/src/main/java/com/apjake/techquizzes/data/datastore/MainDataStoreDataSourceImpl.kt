package com.apjake.techquizzes.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.apjake.techquizzes.data.datasource.MainDataStoreDataSource
import kotlinx.coroutines.flow.first

private const val PREFERENCES_NAME = "QUIZ-APP-PREFERENCES"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class MainDataStoreDataSourceImpl(
    private val context: Context
): MainDataStoreDataSource {
    override suspend fun saveString(key: String, value: String) {
        val prefKey = stringPreferencesKey(key)
        context.dataStore.edit {
            it[prefKey] = value
        }
    }

    override suspend fun getString(key: String): String? {
        val prefKey = stringPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        return preferences[prefKey]
    }

    override suspend fun saveInt(key: String, value: Int) {
        val prefKey = intPreferencesKey(key)
        context.dataStore.edit {
            it[prefKey] = value
        }
    }

    override suspend fun getInt(key: String): Int? {
        val prefKey = intPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        return preferences[prefKey]
    }

    override suspend fun saveLong(key: String, value: Long) {
        val prefKey = longPreferencesKey(key)
        context.dataStore.edit {
            it[prefKey] = value
        }
    }

    override suspend fun getLong(key: String): Long? {
        val prefKey = longPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        return preferences[prefKey]
    }

    override suspend fun saveDouble(key: String, value: Double) {
        val prefKey = doublePreferencesKey(key)
        context.dataStore.edit {
            it[prefKey] = value
        }
    }

    override suspend fun getDouble(key: String): Double? {
        val prefKey = doublePreferencesKey(key)
        val preferences = context.dataStore.data.first()
        return preferences[prefKey]
    }
}