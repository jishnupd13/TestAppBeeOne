package com.app.architecturepattern.domain.usecase.fetchusers

import com.app.architecturepattern.common.Resource
import com.app.architecturepattern.data.remote.dto.toUser
import com.app.architecturepattern.domain.model.User
import com.app.architecturepattern.domain.repository.ApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FetchUserUseCase @Inject constructor(
    private val repository: ApiRepository
) {
    operator fun invoke(): Flow<Resource<List<User>>> = flow {
        try {
            emit(Resource.Loading<List<User>>())
            val coin = repository.fetchUserListResponse().map { it.toUser() }
            emit(Resource.Success<List<User>>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<List<User>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<User>>("Couldn't reach server. Check your internet connection."))
        }
    }
}