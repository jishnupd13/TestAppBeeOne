package com.app.architecturepattern.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun saveName(name: String)
    suspend fun getName(): Flow<String>
}