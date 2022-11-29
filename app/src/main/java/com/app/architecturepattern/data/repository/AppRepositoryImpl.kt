package com.app.architecturepattern.data.repository

import com.app.architecturepattern.data.remote.ApiService
import com.app.architecturepattern.data.remote.dto.UserListResponseDto
import com.app.architecturepattern.domain.repository.ApiRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val api: ApiService
) : ApiRepository {
    override suspend fun fetchUserListResponse(): List<UserListResponseDto> {
        return api.fetchUserListResponse()
    }
}