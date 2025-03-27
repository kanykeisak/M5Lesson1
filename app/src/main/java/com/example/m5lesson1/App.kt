package com.example.m5lesson1

import android.app.Application
import com.example.m5lesson1.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
            androidContext(this@App)
        }
    }
}