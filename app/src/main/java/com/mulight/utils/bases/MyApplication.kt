package com.mulight.utils.bases

import android.app.Application

class MyApplication : Application() {
    companion object {
        var instance: MyApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


    override fun onTerminate() {
        super.onTerminate()
        instance = null
    }
}