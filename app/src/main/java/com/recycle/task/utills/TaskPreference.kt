package com.recycle.task.utills

import android.content.SharedPreferences

class TaskPreference {

    var pref: SharedPreferences? = null
        get() {
            if (field == null) {
                val PRIVATE_MODE = 0
                field = TaskApplication.appContext?.getSharedPreferences(
                    PREFERENCE_NAME,
                    PRIVATE_MODE
                )
            }
            return field
        }
        private set
    var editor: SharedPreferences.Editor? = null
        get() {
            if (field == null) {
                field = pref!!.edit()
            }
            return field
        }
        private set

    fun init() {
        var isFirstTime = isFirstTime
        if (isFirstTime) {
            isFirstTime = false
        }
    }

    private var isFirstTime: Boolean
        private get() {
            var value = true
            if (pref != null && pref!!.contains(IS_FIRST_TIME)) {
                value = pref!!.getBoolean(IS_FIRST_TIME, true)
            }
            return value
        }
        private set(value) {
            editor!!.putBoolean(IS_FIRST_TIME, value)
            editor!!.commit()
        }

    companion object {
        private const val PREFERENCE_NAME = "recyclerGreen"
        private const val IS_FIRST_TIME = "isFirstTime"
        val instance = TaskPreference()
    }
}