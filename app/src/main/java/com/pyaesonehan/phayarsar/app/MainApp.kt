package com.pyaesonehan.phayarsar.app

import android.app.Application
import com.pyaesonehan.phayarsar.di.AppContainer
import com.pyaesonehan.phayarsar.di.DefaultAppContainer

class MainApp: Application() {
    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = DefaultAppContainer()
    }
}