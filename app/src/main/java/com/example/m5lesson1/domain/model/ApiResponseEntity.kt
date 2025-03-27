package com.example.m5lesson1.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponseEntity(
    @SerialName("translations")
    val translations: List<TranslationEntity?>? = null
)