package com.skyfallen.instadev.domain.auth.login.usecase

import com.skyfallen.instadev.domain.auth.login.entity.UserEntity
import com.skyfallen.instadev.domain.auth.login.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(user: String, password: String): UserEntity? {
        if (user.contains("@hotmail.com"))
            return null

        val response = authRepository.doLogin(user, password)
        return response.random()
    }
}