package com.recycle.task.interfaces

import com.google.gson.JsonElement

interface ResponseInterface {
    fun onSuccess(jsonElement: JsonElement, tag:String)
}