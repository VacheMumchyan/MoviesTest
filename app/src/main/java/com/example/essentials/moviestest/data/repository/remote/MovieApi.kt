package com.example.essentials.moviestest.data.repository.remote

import com.example.essentials.moviestest.data.entity.Movie
import com.example.essentials.moviestest.data.entity.MovieDetail
import com.example.essentials.moviestest.data.entity.Result
import com.example.essentials.moviestest.data.entity.Trailer
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface MovieApi {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "api_key",
        @Query("page") page: Int
    ): Call<Result>

    @GET("/3/movie/{id}")
    fun getMovieById(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = "api_key"
    ): Call<MovieDetail>

    @GET("movie/{id}/videos")
    fun  getTrailers(
        @Path("id")  long :Int,
        @Query("api_key") api_key : String
    ):Call<Trailer>








}