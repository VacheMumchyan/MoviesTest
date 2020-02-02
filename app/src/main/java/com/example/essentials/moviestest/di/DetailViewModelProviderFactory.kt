package com.example.essentials.moviestest.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.essentials.moviestest.data.repository.remote.RemoteRepository
import com.example.essentials.moviestest.ui.detail.DetailViewModel
import javax.inject.Inject

class DetailViewModelProviderFactory @Inject constructor(
    private val repository: RemoteRepository
) :  ViewModelProvider.Factory  {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DetailViewModel::class.java!!)) {
            DetailViewModel(
                repository
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}