package com.skyfallen.instadev.data.datasource.api

import com.skyfallen.instadev.data.auth.login.response.UserResponse
import retrofit2.http.GET

interface ApiServices {

    @GET("doLogin/.json")
    suspend fun doLogin(): List<UserResponse>
}