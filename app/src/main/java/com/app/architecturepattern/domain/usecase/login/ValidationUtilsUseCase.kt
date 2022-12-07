package com.app.architecturepattern.domain.usecase.login

import com.app.architecturepattern.domain.repository.ApiRepository
import java.util.regex.Pattern
import javax.inject.Inject

class ValidationUtilsUseCase @Inject constructor(
    private val repository: ApiRepository
) {

    fun validateEmail(email: String): Boolean {
        val emailValidatorPattern = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        return emailValidatorPattern.matcher(email).matches()
    }

    fun validatePassword(password: String): Boolean {
        return password.length > 8
    }
}