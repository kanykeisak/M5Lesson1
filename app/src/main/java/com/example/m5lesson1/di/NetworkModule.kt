package com.example.m5lesson1.di


import com.example.m5lesson1.data.datasource.network.ApiService
import com.example.m5lesson1.data.repository.ApiRepositoryImpl
import com.example.m5lesson1.domain.repository.ApiRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

val networkModule = module {

    single { provideLoggingInterceptor() }
    single { provideOkHttpClient(loggingInterceptor = get()) }
    single { provideJson() }
    single { provideRetrofit(okHttpClient = get(), jsonConverter = get()) }
    single { provideApiService(retrofit = get()) }
    single <ApiRepository>{ ApiRepositoryImpl(apiService = get()) }

    single { Dispatchers.IO }
    single { Dispatchers.Main }
    single { Dispatchers.Default }
    single { Dispatchers.Unconfined }

}

fun provideRetrofit(okHttpClient: OkHttpClient, jsonConverter: Converter.Factory): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(jsonConverter)
        .build()
}

fun provideApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .callTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .addInterceptor(loggingInterceptor)
        .build()
}

fun provideJson(): Converter.Factory {
    val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }
    return json.asConverterFactory("application/json".toMediaType())
}

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}