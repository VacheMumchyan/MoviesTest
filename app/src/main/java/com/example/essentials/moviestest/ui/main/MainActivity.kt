package com.example.essentials.moviestest.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.essentials.moviestest.App
import com.example.essentials.moviestest.R
import com.example.essentials.moviestest.di.ViewModelProviderFactory
import com.example.essentials.moviestest.di.component.DaggerMainActivityComponent
import com.example.essentials.moviestest.di.scope.MainScope
import com.example.essentials.moviestest.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_popular_movie.*
import javax.inject.Inject


@MainScope
class MainActivity : AppCompatActivity(), MoviesAdapter.ItemClickListener {



    @Inject
    lateinit var viewModelProvider: ViewModelProviderFactory
    private lateinit var viewModel: MainViewModel
    private lateinit var popularMoviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivityComponent.builder()
            .appComponent((applicationContext as App).appComponent)
            .build()
            .inject(this)

        viewModel = ViewModelProvider(this, viewModelProvider)[MainViewModel::class.java]


        viewModel.getPopularMovies()

        recycler_movies.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        popularMoviesAdapter =
            MoviesAdapter(this)
        recycler_movies.adapter = popularMoviesAdapter

        viewModel.data.observe(this, Observer {
            println(it)
            popularMoviesAdapter.setData(it.results)
        })

    }

    override fun onItemClick(id: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("key", id)
        startActivity(intent)

    }
}
