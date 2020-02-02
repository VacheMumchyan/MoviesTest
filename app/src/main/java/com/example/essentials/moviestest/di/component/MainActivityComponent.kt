package com.example.essentials.moviestest.di.component

import com.example.essentials.moviestest.di.module.MainViewModelFactoryModule
import com.example.essentials.moviestest.di.scope.MainScope
import com.example.essentials.moviestest.ui.main.MainActivity
import dagger.Component


@MainScope
@Component(
    dependencies = [AppComponent::class], modules = [MainViewModelFactoryModule::class]
)
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

}