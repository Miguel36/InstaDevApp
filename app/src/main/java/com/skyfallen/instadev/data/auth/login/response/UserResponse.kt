package com.skyfallen.instadev.data.auth.login.response

import com.skyfallen.instadev.domain.auth.login.entity.UserEntity
import com.skyfallen.instadev.domain.auth.login.entity.UserMode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Response model
@Serializable
data class UserResponse(
    val userId: String,
    val name: String,
    @SerialName("nickname") val nickName: String,
    val followers: Int = 0,
    val following: List<String>,
    @SerialName("usertype") val userType: Int
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
