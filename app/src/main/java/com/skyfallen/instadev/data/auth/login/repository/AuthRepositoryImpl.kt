package com.skyfallen.instadev.data.auth.login.repository

import com.skyfallen.instadev.data.auth.login.response.ToDomain
import com.skyfallen.instadev.data.auth.login.response.UserResponse
import com.skyfallen.instadev.data.datasource.api.ApiServices
import com.skyfallen.instadev.domain.auth.login.entity.UserEntity
import com.skyfallen.instadev.domain.auth.login.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(api: ApiServices) : AuthRepository {

    override suspend fun doLogin(user: String, password: String): UserEntity {
        return withContext(Dispatchers.IO) {
            val userResponse = UserResponse("007", "Agente", "Agente 007", 100, listOf(""), 0)

            // witContext returns the last value of the block
            userResponse.ToDomain()
        }
    }
}