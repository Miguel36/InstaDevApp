package com.skyfallen.instadev.domain.auth.login.usecase

import com.skyfallen.instadev.domain.auth.login.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {

    operator fun invoke(user: String, password: String) {
        if (user.contains("@hotmail.com"))
            return
        val response = authRepository.doLogin(user, password)
    }
}