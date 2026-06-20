package com.galaxy.stream

/**
 * Represents a single stream entry shown in the channel list.
 * `streamUrl` should point to a licensed/owned HLS (.m3u8) or DASH (.mpd) source.
 * This is just a placeholder model — wire it up to your own backend/API.
 */
data class Channel(
    val id: String,
    val title: String,
    val subtitle: String,
    val thumbnailUrl: String?,
    val streamUrl: String,
    val isLive: Boolean = false
)
