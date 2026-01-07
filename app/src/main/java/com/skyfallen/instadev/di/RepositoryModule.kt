package com.skyfallen.instadev.di

import com.skyfallen.instadev.data.auth.login.repository.AuthRepositoryImpl
import com.skyfallen.instadev.domain.auth.login.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesLoginRepository() : AuthRepository {
        return AuthRepositoryImpl()
    }
}