package com.skyfallen.instadev.domain.auth.login.repository

import com.skyfallen.instadev.domain.auth.login.entity.UserEntity

interface AuthRepository {
    fun doLogin(user: String, password: String): UserEntity
}