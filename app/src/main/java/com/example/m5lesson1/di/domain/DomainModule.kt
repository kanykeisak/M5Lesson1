package com.example.m5lesson1.di.domain

import com.example.m5lesson1.domain.networkusecase.GetTextUseCase
import com.example.m5lesson1.domain.usecases.DecrementUseCase
import com.example.m5lesson1.domain.usecases.GetCountUseCase
import com.example.m5lesson1.domain.usecases.IncrementUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { IncrementUseCase(get()) }
    factory { DecrementUseCase(get()) }
    factory { GetCountUseCase(get()) }

    single { GetTextUseCase(apiRepository = get()) }
}