package com.app.architecturepattern.common

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreHandler @Inject constructor(
    private val dataStorePreferences: DataStore<Preferences>
) {

    private val NAME = stringPreferencesKey("Name")

    suspend fun saveName(name: String) {
        dataStorePreferences.edit { mutablePreferences ->
            mutablePreferences[NAME] = name
        }
    }

    fun fetchName() = flow {
        dataStorePreferences.data.map { value: Preferences ->
            emit(value[NAME] ?: "")
        }.collect()
    }

}