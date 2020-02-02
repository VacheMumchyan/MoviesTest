package com.example.essentials.moviestest.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.essentials.moviestest.di.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class MainViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelModelFactory(modelProviderProviderFactory: ViewModelProviderFactory)
            : ViewModelProvider.Factory
}