package com.example.m5lesson1.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("translations")
    val translations: List<Translation?>? = null
)