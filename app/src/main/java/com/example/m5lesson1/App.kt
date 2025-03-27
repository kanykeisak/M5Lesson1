package com.example.m5lesson1

import android.app.Application
import com.example.m5lesson1.di.data.dataModule
import com.example.m5lesson1.di.domain.domainModule
import com.example.m5lesson1.di.presentation.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(dataModule, domainModule, presentationModule)
            androidContext(this@App)
        }
    }
}