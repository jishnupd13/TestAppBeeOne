package com.app.architecturepattern.data.remote

import com.app.architecturepattern.data.remote.dto.UserListResponseDto
import retrofit2.http.GET

interface ApiService {

    @GET("v2/5d565297300000680030a986")
    suspend fun fetchUserListResponse(): List<UserListResponseDto>
}