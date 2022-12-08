package com.app.architecturepattern.presentation.ui.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.architecturepattern.common.DataStoreHandler
import com.app.architecturepattern.presentation.navigation.routes.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataStoreHandler: DataStoreHandler
) : ViewModel() {

    val isLoading = mutableStateOf("")

    init {
        fetchEmail()
    }

    private fun fetchEmail() = viewModelScope.launch {
        dataStoreHandler.fetchEmail().collect {
            val screen = if (it.isEmpty()) Routes.Login.route else Routes.HomeScreen.route
            isLoading.value = screen
        }
    }
}

