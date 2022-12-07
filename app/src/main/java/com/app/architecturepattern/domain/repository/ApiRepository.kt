package com.app.architecturepattern.domain.repository

import com.app.architecturepattern.data.remote.dto.UserListResponseDto

interface ApiRepository {

    suspend fun fetchUserListResponse(): List<UserListResponseDto>

}