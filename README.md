# Galaxy Stream

Android skeleton for a sports/video streaming app, built around Media3 ExoPlayer.

## Structure
- `ui/MainActivity.kt` — channel list (RecyclerView). Currently loads one placeholder
  channel pointing at a public Mux test HLS stream so you can verify playback works.
- `ui/ChannelAdapter.kt` — list adapter.
- `player/PlayerActivity.kt` — ExoPlayer-based player screen, supports HLS (.m3u8) and
  DASH (.mpd), plus native Android Picture-in-Picture.
- `player/FloatingPlayerService.kt` — minimal foreground service stub for background
  playback. Extend with a `WindowManager` overlay if you want a true floating window
  instead of native PiP.
- `Channel.kt` — data model for a stream entry.

## What's NOT included (by design)
No content/backend. `fetchChannelsPlaceholder()` in `MainActivity.kt` is a stub —
wire it to your own API (Retrofit/Ktor/Supabase) that returns channels whose
`streamUrl` points to content you own or are licensed to distribute.

## Next steps
1. Open in Android Studio, sync Gradle.
2. Replace the placeholder stream with your own test HLS URL to confirm playback.
3. Build a backend (could reuse your Supabase setup from BlizzByte) with a
   `channels` table: id, title, subtitle, thumbnail_url, stream_url, is_live.
4. Swap `fetchChannelsPlaceholder()` for a real network call.
5. Add auth/paywall if needed, push notifications (Firebase) for "going live" alerts.
