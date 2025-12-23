package com.skyfallen.instadev.domain.auth.login.repository

interface AuthRepository {
    fun doLogin(user: String, password: String): Boolean
}