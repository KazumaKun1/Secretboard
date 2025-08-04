package com.arviejhay.secretboard.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: String,
    val name: String?,
    val title: String?,
    val message: String,
    val timestamp: Long?
)

expect fun Long.formatAsDate(): String
