package com.app.architecturepattern.domain.model

import com.app.architecturepattern.data.remote.dto.Company

data class User(
    val id: Int? = 0,
    val name: String? = "",
    val email: String? = "",
    val phone: String? = "",
    val company: Company? = null
)