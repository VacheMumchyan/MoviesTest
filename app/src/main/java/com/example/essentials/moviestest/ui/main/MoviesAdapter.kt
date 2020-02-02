package com.example.essentials.moviestest.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.essentials.moviestest.R
import com.example.essentials.moviestest.data.entity.Movie

class MoviesAdapter(val adapterOnClick: ItemClickListener) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private var  movies = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie, parent, false)

        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun setData(list : List<Movie>) {
        movies.clear()
        movies.addAll(list)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvOverView: TextView = itemView.findViewById(R.id.tv_overview)
        private val poster: ImageView = itemView.findViewById(R.id.imgMovePoster)


        fun bind(movie: Movie) {
            tvTitle.text = movie.title
            tvOverView.text = movie.overview
             Glide.with(itemView)
                 .load("https://image.tmdb.org/t/p/w342${movie.posterPath}")
                 .transform(CenterCrop())
                 .into(poster)

            itemView.setOnClickListener {
                adapterOnClick.onItemClick(movies[adapterPosition].id)
            }


        }
    }

    interface ItemClickListener{
        fun onItemClick(id: Int)
    }

}