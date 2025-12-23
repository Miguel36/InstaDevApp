package com.skyfallen.instadev.data.auth.login.repository

import com.skyfallen.instadev.data.auth.login.response.ToDomain
import com.skyfallen.instadev.data.auth.login.response.UserResponse
import com.skyfallen.instadev.domain.auth.login.entity.UserEntity
import com.skyfallen.instadev.domain.auth.login.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {

    override fun doLogin(user: String, password: String): UserEntity {
        val userResponse = UserResponse("007", "Agente", "Agente 007", 100, listOf(""), 0)

        return userResponse.ToDomain()
    }
}