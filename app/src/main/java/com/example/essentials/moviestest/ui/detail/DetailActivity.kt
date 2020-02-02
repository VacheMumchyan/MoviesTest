package com.example.essentials.moviestest.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.essentials.moviestest.App
import com.example.essentials.moviestest.R
import com.example.essentials.moviestest.di.DetailViewModelProviderFactory
import com.example.essentials.moviestest.di.component.DaggerDetailActivityComponent
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(),
    TrailerAdapter.TrailerItemCliclListener {

    @Inject
    lateinit var mainViewModelProvider: DetailViewModelProviderFactory
    private lateinit var viewModel: DetailViewModel

    private lateinit var trailerAdapter: TrailerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailId = intent.getIntExtra("key", -12)

        DaggerDetailActivityComponent.builder()
            .appComponent((applicationContext as App).appComponent)
            .build()
            .inject(this)

        recycler_trailer.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        trailerAdapter =
            TrailerAdapter(this)
        recycler_trailer.adapter = trailerAdapter

        viewModel = ViewModelProvider(this, mainViewModelProvider)[DetailViewModel::class.java]

        viewModel.getDetailById(detailId)

        viewModel.data.observe(this, Observer {
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w342${it.poster_path}")
                .transform(CenterCrop())
                .into(imgPoster)
            tvGenre.text = it.genres[0].name
            tvTitle.text = it.title
            tvBudget.text = it.budget.toString()
            tvRelease.text = it.release_date
            tv_overview_content.text = it.overview
        })

        viewModel.trailer.observe(this, Observer {
            trailerAdapter.setData(it.results)
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left)
    }

    override fun onItemClick(id: String, key: String) {
        val intent = Intent(this, YoutubeActivit::class.java)
        intent.putExtra("keyYoutube", key)
        startActivity(intent)
    }
}
