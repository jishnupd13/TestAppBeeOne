package com.app.architecturepattern.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.app.architecturepattern.common.DataStoreHandler
import com.app.architecturepattern.domain.usecase.login.ValidationUtilsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val dataStoreHandler: DataStoreHandler,
    private val validationUtilsUseCase: ValidationUtilsUseCase
) : ViewModel() {
}