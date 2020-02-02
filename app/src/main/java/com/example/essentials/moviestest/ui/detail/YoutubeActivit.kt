package com.example.essentials.moviestest.ui.detail

import android.os.Bundle
import android.widget.Toast
import com.example.essentials.moviestest.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_youtubet.*

class YoutubeActivit : YouTubeBaseActivity() {


    private val API_KEY = "AIzaSyCVKyd_N3R2tT2nH5ALR8x3JuE3SMvUIRA"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtubet)

        val key = intent.getStringExtra("keyYoutube")

        player?.initialize(API_KEY, object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider,
                youTubePlayer: YouTubePlayer,
                b: Boolean
            ) {
                if (!b) {
                    youTubePlayer.loadVideo(key)
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)
                }
            }

            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider,
                youTubeInitializationResult: YouTubeInitializationResult
            ) {
                Toast.makeText(this@YoutubeActivit, youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }
}
