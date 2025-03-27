package com.example.m5lesson1.data.repository

import com.example.m5lesson1.data.datasource.network.ApiService

class ApiRepositoryImpl(private val apiService: ApiService) : ApiRepository {
    override suspend fun translateText(apiKey: String, text: String, targetLang: String): String {
        val response = apiService.translateText(apiKey, text, targetLang)
        return response.translations?.firstOrNull()?.text ?: "Ошибка перевода"
    }
}