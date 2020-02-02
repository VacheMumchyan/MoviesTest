package com.example.essentials.moviestest.data.entity

data class Result(
    val page : Int,
    val total_results : Int,
    val total_pages : Int,
    val results : List<Movie>

 )