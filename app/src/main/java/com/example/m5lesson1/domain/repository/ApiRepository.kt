package com.example.m5lesson1.domain.repository

interface ApiRepository {
    suspend fun translateText(apiKey: String, text: String, targetLang: String): String
}