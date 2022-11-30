package com.app.architecturepattern.presentation.ui.datastore

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.app.architecturepattern.domain.usecase.datastore.DataStoreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DataStoreImplementationViewModel @Inject constructor(
    private val dataStoreUseCase: DataStoreUseCase
) : ViewModel() {

    private val _state = mutableStateOf("")
    val state: State<String> = _state

    fun saveUserName(name: String) {
        dataStoreUseCase.saveName(name)
    }

    fun fetchUserName() {
        dataStoreUseCase.fetchName().onEach { name ->
            _state.value = name
        }
    }
}