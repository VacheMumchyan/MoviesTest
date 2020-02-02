package com.example.essentials.moviestest.di.module

import com.example.essentials.moviestest.data.repository.remote.MovieApi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    val BASE_URL = "https://api.themoviedb.org/3/"
    //Response{protocol=h2, code=200, message=, url=https://api.themoviedb.org/3/ccc?api_key=f200ea93d28d03201a0e1caee1ebd3e6}

    @Singleton
    @Provides
    internal fun providePostApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Singleton
    @Provides
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}