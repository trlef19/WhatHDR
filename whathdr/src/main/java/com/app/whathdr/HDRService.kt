package com.app.whathdr

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.hardware.display.DisplayManager
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat

class HDRService : Service() {

    private lateinit var displayManager: DisplayManager
    private val notificationManager by lazy {
        getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    }

    private val displayListener = object : DisplayManager.DisplayListener {
        var alreadyPlayingHdr = false
        override fun onDisplayAdded(displayId: Int) {}
        override fun onDisplayChanged(displayId: Int) {
            val display = displayManager.getDisplay(displayId)
            if (display != null && display.hdrSdrRatio!=1.0f && display.hdrSdrRatio!=3.01f) {
                if (!alreadyPlayingHdr)
                    sendHdrPlayingNotification()
                alreadyPlayingHdr = true
            }
            else if (alreadyPlayingHdr && display.hdrSdrRatio==1.0f)
                alreadyPlayingHdr = false
        }
        override fun onDisplayRemoved(displayId: Int) {}
    }

    override fun onBind(intent: Intent?): IBinder? = null
    companion object {
        var isRunning = false
        private set
    }
    override fun onCreate() {
        super.onCreate()
        displayManager = getSystemService(DISPLAY_SERVICE) as DisplayManager
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            Actions.START.toString() -> startService()
            Actions.STOP.toString() -> stopService()
        }
        return START_STICKY
    }

    private fun startService() {
        val notification = NotificationCompat.Builder(this, "hdr_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(getString(R.string.whathdr_service))
            .setContentText(getString(R.string.hdr_detection))
            .setOngoing(true)
            .build()

        startForeground(1, notification)
        isRunning = true
        displayManager.registerDisplayListener(displayListener, null)
    }

    private fun stopService() {
        displayManager.unregisterDisplayListener(displayListener)
        stopForeground(STOP_FOREGROUND_REMOVE)
        isRunning = false
        stopSelf()
    }

    private fun sendHdrPlayingNotification() {
        val toast = Toast.makeText(this, getString(R.string.hdr_signal), Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            "hdr_channel",
            getString(R.string.hdr_notifications),
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = getString(R.string.notifications_for_hdr_playback)
        }
        notificationManager.createNotificationChannel(channel)
    }

    override fun onDestroy() {
        super.onDestroy()
        displayManager.unregisterDisplayListener(displayListener)
    }

    enum class Actions {
        START, STOP
    }
}
