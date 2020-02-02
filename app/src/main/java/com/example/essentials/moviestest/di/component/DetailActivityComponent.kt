package com.example.essentials.moviestest.di.component

import com.example.essentials.moviestest.di.module.DetailViewModelFactoryModule
import com.example.essentials.moviestest.di.scope.DetailScope
import com.example.essentials.moviestest.ui.detail.DetailActivity
import dagger.Component

@DetailScope
@Component(
    dependencies = [AppComponent::class], modules = [DetailViewModelFactoryModule::class]
)
interface DetailActivityComponent {

    fun inject(detailActivity: DetailActivity)
}