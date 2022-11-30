package com.app.architecturepattern.domain.usecase.datastore

import android.util.Log
import com.app.architecturepattern.domain.repository.DataStoreRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DataStoreUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {

    //save the name in the data store
    fun saveName(name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            dataStoreRepository.saveName(name)
        }
    }

    fun fetchName(): Flow<String> = flow {
        dataStoreRepository.getName().collect{
            emit(it)
        }

    }
}