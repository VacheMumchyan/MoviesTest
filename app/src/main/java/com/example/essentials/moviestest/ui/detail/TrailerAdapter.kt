package com.example.essentials.moviestest.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.essentials.moviestest.R
import com.example.essentials.moviestest.data.entity.ResultDetail

class TrailerAdapter(val adapterOnClick: TrailerItemCliclListener) :
    RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder>() {

    private var movies = ArrayList<ResultDetail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_trailer, parent, false)
        return TrailerViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: TrailerViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun setData(list: List<ResultDetail>) {
        movies.clear()
        movies.addAll(list)
        notifyDataSetChanged()
    }

    inner class TrailerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgTrailer: ImageView = itemView.findViewById(R.id.img_trailer)
//https://img.youtube.com/vi/bJgFuw0-KdE/0.jpg
        fun bind(movie: ResultDetail) {
            Glide.with(itemView)
                .load("https://img.youtube.com/vi/${movie.key+ "/0.jpg"}")
                .transform(CenterCrop())
                .into(imgTrailer)

            itemView.setOnClickListener {
                adapterOnClick.onItemClick(movies[adapterPosition].id, movies[adapterPosition].key)
            }
        }
    }

    interface TrailerItemCliclListener {
        fun onItemClick(id: String, key : String)
    }
}