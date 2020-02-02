package com.example.essentials.moviestest.data.repository.remote

import com.example.essentials.moviestest.data.entity.MovieDetail
import com.example.essentials.moviestest.data.entity.Result
import com.example.essentials.moviestest.data.entity.Trailer
import retrofit2.Call
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val api: MovieApi){

    fun getPopularMovies(api_key : String, page : Int): Call<Result> = api.getPopularMovies(api_key, page)

    fun getMovieByID( id : Int, api_key: String) : Call<MovieDetail> = api.getMovieById(id, api_key)

    fun getTrailers( id: Int , api_key: String) : Call<Trailer> = api.getTrailers(id, api_key)
}