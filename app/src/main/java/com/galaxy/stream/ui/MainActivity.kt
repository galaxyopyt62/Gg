package com.galaxy.stream.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.galaxy.stream.Channel
import com.galaxy.stream.player.PlayerActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.galaxy.stream.R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(com.galaxy.stream.R.id.channelList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // TODO: replace with a real backend call (Retrofit/Ktor/Supabase etc.)
        // returning channels whose streamUrl points to content you own or are licensed to show.
        val channels = fetchChannelsPlaceholder()

        recyclerView.adapter = ChannelAdapter(channels) { channel ->
            val intent = Intent(this, PlayerActivity::class.java)
            intent.putExtra(PlayerActivity.EXTRA_STREAM_URL, channel.streamUrl)
            intent.putExtra(PlayerActivity.EXTRA_TITLE, channel.title)
            startActivity(intent)
        }
    }

    private fun fetchChannelsPlaceholder(): List<Channel> = listOf(
        Channel(
            id = "demo-1",
            title = "Sample Channel",
            subtitle = "Replace with your own licensed stream",
            thumbnailUrl = null,
            streamUrl = "https://test-streams.mux.dev/x36xhzz/x36xhzz.m3u8", // public test HLS stream
            isLive = false
        )
    )
}
