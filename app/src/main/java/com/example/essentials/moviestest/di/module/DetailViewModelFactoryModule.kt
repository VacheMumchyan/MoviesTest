package com.example.essentials.moviestest.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.essentials.moviestest.di.DetailViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class DetailViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelModelFactory(modelProviderProviderFactory: DetailViewModelProviderFactory)
            : ViewModelProvider.Factory
}