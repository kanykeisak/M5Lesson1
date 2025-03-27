package com.example.m5lesson1.di

import com.example.m5lesson1.di.data.dataModule
import com.example.m5lesson1.di.domain.domainModule
import com.example.m5lesson1.di.presentation.presentationModule

val appModule = listOf(dataModule, domainModule, presentationModule, networkModule)