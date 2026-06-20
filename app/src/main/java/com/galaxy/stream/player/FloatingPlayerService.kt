package com.galaxy.stream.player

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.galaxy.stream.R

/**
 * Minimal foreground service so playback can continue while the app is backgrounded.
 * Extend this with a WindowManager overlay if you want a true floating (over-other-apps)
 * mini player rather than relying on Android's native Picture-in-Picture API.
 */
class FloatingPlayerService : Service() {

    private val channelId = "galaxy_stream_playback"

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId, "Playback", NotificationManager.IMPORTANCE_LOW
            )
            getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification: Notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Galaxy Stream")
            .setContentText("Playing in background")
            .setSmallIcon(R.mipmap.ic_launcher)
            .build()
        startForeground(1, notification)
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
