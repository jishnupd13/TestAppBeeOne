package com.app.architecturepattern.presentation.ui.login.components

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.architecturepattern.common.DataStoreHandler
import com.app.architecturepattern.domain.usecase.login.ValidationUtilsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataStoreHandler: DataStoreHandler,
    private val validationUtilsUseCase: ValidationUtilsUseCase
) : ViewModel() {

    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val emailValidationStatus = mutableStateOf(false)
    val passwordValidationStatus = mutableStateOf(false)

    fun validateLogin() {
        when {

            !validationUtilsUseCase.validateEmail(email = email.value) -> {
                emailValidationStatus.value = true
                passwordValidationStatus.value = false
            }

            !validationUtilsUseCase.validatePassword(password.value) -> {
                passwordValidationStatus.value = true
                emailValidationStatus.value = false
            }

            else -> {
                emailValidationStatus.value = false
                passwordValidationStatus.value = false
                viewModelScope.launch {
                    dataStoreHandler.saveEmail(email = email.value)
                }
            }
        }
    }


}