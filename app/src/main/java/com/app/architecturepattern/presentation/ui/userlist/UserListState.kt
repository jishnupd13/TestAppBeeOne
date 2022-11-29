package com.app.architecturepattern.presentation.ui.userlist

import com.app.architecturepattern.domain.model.User


data class UserListState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)