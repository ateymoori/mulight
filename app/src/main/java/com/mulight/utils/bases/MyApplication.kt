package com.mulight.utils.bases

import android.app.Application
import com.mulight.repo.DBHelper

class MyApplication : Application() {
    companion object {
        var instance: MyApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        DBHelper.getInstance()
    }


    override fun onTerminate() {
        super.onTerminate()
        instance = null
        DBHelper.destroyInstance()
    }
}