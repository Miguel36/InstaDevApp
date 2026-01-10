package com.skyfallen.instadev.data.auth.login.repository

import android.util.Log
import com.skyfallen.instadev.data.auth.login.response.ToDomain
import com.skyfallen.instadev.data.datasource.api.ApiServices
import com.skyfallen.instadev.domain.auth.login.entity.UserEntity
import com.skyfallen.instadev.domain.auth.login.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val api: ApiServices) : AuthRepository {

    override suspend fun doLogin(user: String, password: String): List<UserEntity> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.doLogin()

                // witContext returns the last value of the block
                response.map { it.ToDomain() }
            }
            catch (e: Exception) {
                Log.e("DoLoginError", "$e")
                emptyList()
            }
        }
    }
}