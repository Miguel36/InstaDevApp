package com.skyfallen.instadev.domain.auth.login.entity

data class UserEntity(
    val userId: String,
    val name: String,
    val nickName: String,
    val followers: Int,
    val following: List<String>,
    val userType: UserMode
)

enum class UserMode(val type: Int) {
    REGULAR_USER(0),
    CONTENT_CREATOR_USER(1),
    COMPANY_USER(2);

    companion object {
        fun fromType(type: Int): UserMode = entries.find { it.type == type } ?: REGULAR_USER // Secure default
    }
}
