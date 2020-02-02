package com.example.essentials.moviestest.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.essentials.moviestest.data.entity.Movie
import com.example.essentials.moviestest.data.entity.MovieDetail
import com.example.essentials.moviestest.data.entity.Result
import com.example.essentials.moviestest.data.entity.Trailer
import com.example.essentials.moviestest.data.repository.remote.RemoteRepository
import com.example.essentials.moviestest.utils.Constanat.Companion.API_KEY
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val repository: RemoteRepository
) :ViewModel() {

    var data = MutableLiveData<MovieDetail>()
    var trailer = MutableLiveData<Trailer>()

    fun getDetailById(id : Int){
        repository.getMovieByID(id, API_KEY)
            .enqueue(object : Callback<MovieDetail> {
                override fun onFailure(call: Call<MovieDetail>?, t: Throwable?) {

                }
                override fun onResponse(call: Call<MovieDetail>?, response: Response<MovieDetail>?) {
                   data.value = response?.body()
                }
            })

        repository.getTrailers(id, API_KEY)
            .enqueue(object : Callback<Trailer> {
                override fun onFailure(call: Call<Trailer>?, t: Throwable?) {

                }
                override fun onResponse(call: Call<Trailer>?, response: Response<Trailer>?) {
                   trailer.value = response?.body()


                }
            })
    }


}