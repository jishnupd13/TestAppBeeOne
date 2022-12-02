package com.app.architecturepattern.presentation.ui.login.components

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.app.architecturepattern.common.DataStoreHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val dataStoreHandler: DataStoreHandler
) : ViewModel() {

    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val emailValidationStatus = mutableStateOf(false)
    val passwordValidationStatus = mutableStateOf(false)

    fun validateLogin() {
        if (email.value.isEmpty()) {
            emailValidationStatus.value = true
        } else if (password.value.isEmpty()) {
            passwordValidationStatus.value = true
        } else {
            emailValidationStatus.value = false
            passwordValidationStatus.value = false
        }
    }


}