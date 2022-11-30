package com.app.architecturepattern.presentation.ui.datastore

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.architecturepattern.domain.usecase.datastore.DataStoreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class DataStoreImplementationViewModel @Inject constructor(
    private val dataStoreUseCase: DataStoreUseCase
) : ViewModel() {

    private val _state = mutableStateOf("")
    val state: State<String> = _state

    fun saveUserName(name: String) {
        dataStoreUseCase.saveName(name)
    }

    fun fetchUserName()=viewModelScope.launch {
        dataStoreUseCase.fetchName().collect{
            Log.d("value", "fetchUserName: $it")
        }

//            .onEach { name ->
//            _state.value = name
//        }
    }
}