package com.example.m5lesson1.di.data

import com.example.m5lesson1.data.datasource.EmulateService
import com.example.m5lesson1.data.repository.CounterRepositoryImpl
import com.example.m5lesson1.domain.repository.CounterRepository
import org.koin.dsl.module

val dataModule = module {
    single<CounterRepository> {
        CounterRepositoryImpl(get())
    }

    single { EmulateService() }
}