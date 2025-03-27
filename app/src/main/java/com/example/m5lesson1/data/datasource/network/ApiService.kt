package com.example.m5lesson1.data.datasource.network

import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @Headers(
        "Content-Type: application/x-www-form-urlencoded"
    )
    @POST("v2/translate")
    suspend fun translateText(
        @Query("auth_key") apiKey: String,  // Должно быть Query, а не Body
        @Query("text") text: String,
        @Query("target_lang") targetLang: String
    ): ApiResponse
}