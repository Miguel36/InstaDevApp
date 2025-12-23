package com.skyfallen.instadev.data.auth.login.response

import com.skyfallen.instadev.domain.auth.login.entity.UserEntity
import com.skyfallen.instadev.domain.auth.login.entity.UserMode

// Response model
data class UserResponse(
    val userId: String,
    val name: String,
    val nickName: String,
    val followers: Int,
    val following: List<String>,
    val userType: Int
)

fun UserResponse.ToDomain(): UserEntity {
    val userMode = UserMode.fromType(userType)

    return UserEntity(
        userId = userId,
        name = name,
        nickName = nickName,
        followers = followers,
        following = following,
        userType = userMode
    )
}
