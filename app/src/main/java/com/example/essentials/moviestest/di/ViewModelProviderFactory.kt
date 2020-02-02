package com.example.essentials.moviestest.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.essentials.moviestest.data.repository.remote.RemoteRepository
import com.example.essentials.moviestest.ui.main.MainViewModel
import javax.inject.Inject

class ViewModelProviderFactory @Inject constructor(
    private val repository: RemoteRepository,
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java!!)) {
            MainViewModel(
                repository,
                context
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}