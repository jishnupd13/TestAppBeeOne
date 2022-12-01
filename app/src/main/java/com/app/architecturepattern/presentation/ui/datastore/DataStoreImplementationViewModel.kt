package com.app.architecturepattern.presentation.ui.datastore

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.architecturepattern.common.DataStoreHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataStoreImplementationViewModel @Inject constructor(
    private val dataStoreHandler: DataStoreHandler
) : ViewModel() {

    private val _state = mutableStateOf("")
    val state: State<String> = _state

    fun saveUserName(name: String) {
        viewModelScope.launch {
            dataStoreHandler.saveName(name)
            fetchUserName()
        }
    }

    fun fetchUserName() = viewModelScope.launch {
        dataStoreHandler.fetchName().collect {
            _state.value = it
        }
    }
}