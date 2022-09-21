package com.recycle.task.utills

import android.app.Application
import android.content.Context

class TaskApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this
        appContext = applicationContext
        TaskPreference.instance.init()
        //   SendOTP.initializeApp(this,"authKey");
    }

    companion object {

        var appContext: Context? = null
            private set

        @get:Synchronized
        var instance: TaskApplication? = null
            private set

    }
}