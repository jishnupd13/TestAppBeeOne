package com.app.architecturepattern.presentation.ui.userlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.architecturepattern.common.Resource
import com.app.architecturepattern.domain.usecase.fetchusers.FetchUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    val fetchUserUseCase: FetchUserUseCase
) : ViewModel() {



    private val _state = mutableStateOf(UserListState())
    val state: State<UserListState> = _state

    init {
        fetchUserList()
    }


    private fun fetchUserList() {
        fetchUserUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UserListState(users = result.data!!)
                }
                is Resource.Error -> {
                    _state.value = UserListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = UserListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}