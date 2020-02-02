package com.example.essentials.moviestest.ui.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.essentials.moviestest.data.entity.Result
import com.example.essentials.moviestest.data.repository.remote.RemoteRepository
import com.example.essentials.moviestest.utils.Constanat.Companion.API_KEY
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainViewModel  @Inject constructor(
    private val repository: RemoteRepository,
    val context: Context
): ViewModel() {
    var data = MutableLiveData<Result>()

    fun getPopularMovies() {
        return repository.getPopularMovies(API_KEY, 2)
            .enqueue(object : Callback<Result> {
                override fun onFailure(call: Call<Result>?, t: Throwable?) {

                }
                override fun onResponse(call: Call<Result>?, response: Response<Result>?) {
                    data.value = response?.body()
                }
            })
    }
}

//    fun getUsers(): Single<Result> {
//        //Create the data for your UI, the users lists and maybe some additional data needed as well
//        return repository.setLocation("", 4)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(t1 -> {}, )
//
//
//}