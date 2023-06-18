package com.project.assignment

import android.app.Application
import androidx.lifecycle.LifecycleObserver


class MainApplication : Application(), LifecycleObserver {

    companion object {
        lateinit var instance: MainApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

    }




}





