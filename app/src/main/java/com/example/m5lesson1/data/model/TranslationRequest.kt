package com.example.m5lesson1.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TranslationRequest(
    @SerialName("text") val text: String,
    @SerialName("target_lang") val targetLang: String
)