package com.app.whathdr

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

class WhatHDR: Application() {
    override fun onCreate() {
        super.onCreate()
        val channel = NotificationChannel(
            "hdr_channel",
            "HDR Service",
            NotificationManager.IMPORTANCE_LOW
        )

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}