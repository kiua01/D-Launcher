package com.dlauncher.core.model

import kotlinx.serialization.Serializable

@Serializable
data class MinecraftVersion(
    val id: String,
    val type: String,
    val url: String,
    val time: String,
    val releaseTime: String
)

@Serializable
data class Account(
    val id: String,
    val username: String,
    val type: AccountType,
    val accessToken: String? = null
)

enum class AccountType {
    OFFLINE, MICROSOFT
}

data class Instance(
    val id: String,
    val name: String,
    val versionId: String,
    val gameDir: String,
    val javaPath: String? = null,
    val jvmArgs: List<String> = emptyList()
)
