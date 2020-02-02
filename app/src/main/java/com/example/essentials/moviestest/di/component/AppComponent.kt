package com.example.essentials.moviestest.di.component

import android.content.Context
import com.example.essentials.moviestest.data.repository.remote.RemoteRepository
import com.example.essentials.moviestest.di.module.AppModule
import com.example.essentials.moviestest.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component( modules = [
    AppModule::class,
    NetworkModule::class
])
interface AppComponent {

    fun getContext() : Context

    fun getRemoteRepository(): RemoteRepository

}