package com.app.architecturepattern.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.app.architecturepattern.common.Constants.DATA_STORE_NAME
import com.app.architecturepattern.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = DATA_STORE_NAME)

class DataStoreRepositoryImpl(private val context: Context) : DataStoreRepository {

    companion object {
        val NAME = stringPreferencesKey("NAME")
    }

    override suspend fun saveName(name: String) {
        context.datastore.edit { dataStore ->
            dataStore[NAME] = name
        }
    }

    override suspend fun getName(): Flow<String> = context.datastore.data.map { dataStore ->
        dataStore[NAME] ?: ""
    }
}