package com.gzslt.boardgame

import android.app.Application
import logcat.AndroidLogcatLogger
import logcat.LogPriority

class BoardGameApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        AndroidLogcatLogger.installOnDebuggableApp(this, LogPriority.VERBOSE)
    }
}
