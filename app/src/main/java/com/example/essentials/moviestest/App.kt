package com.example.essentials.moviestest

import android.app.Application
import com.example.essentials.moviestest.di.component.AppComponent
import com.example.essentials.moviestest.di.component.DaggerAppComponent
import com.example.essentials.moviestest.di.module.AppModule
import com.example.essentials.moviestest.di.module.NetworkModule

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}