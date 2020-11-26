package com.hkq.use_hilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Hilt 目前支持以下 Android 类：
 * Application（通过使用 @HiltAndroidApp）
 * Activity
 * Fragment
 * View
 * Service
 * BroadcastReceiver
 */
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}