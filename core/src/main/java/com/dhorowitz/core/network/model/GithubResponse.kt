package com.dhorowitz.core.network.model

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class PRDto(
    val id: String,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
    val user: GithubUserDto
)

@Keep
@JsonClass(generateAdapter = true)
data class GithubUserDto(
    val login: String,
    @Json(name = "avatar_url") val imageUrl: String
)