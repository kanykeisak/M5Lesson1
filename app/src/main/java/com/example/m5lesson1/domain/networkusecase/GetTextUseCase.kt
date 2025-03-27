package com.example.m5lesson1.domain.networkusecase

class GetTextUseCase(private val apiRepository: ApiRepository) {
    suspend fun execute(apiKey: String, text: String, targetLang: String): String {
        return apiRepository.translateText(apiKey, text, targetLang)
    }
}