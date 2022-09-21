package com.recycle.task.utills

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.json.JSONObject

object Config {
    fun getJsonObjectString(jsonObject: JsonObject, key:String?):String{
        if (jsonObject[key]!=null){
            if (!jsonObject[key].isJsonNull){
                return jsonObject[key].asString
            }
        }
        return ""
    }

    fun getjsonObject(jsonObject: JsonObject, key: String?):JsonObject?{
        if (jsonObject[key] != null){
            if (!jsonObject[key].isJsonNull){
                return jsonObject[key].asJsonObject
            }
        }
        return null
    }

    fun getJsonArray(jsonObject: JsonObject?, key: String?):JsonArray?{
        return try {
            if (jsonObject == null || !jsonObject.has(key)){
                return null
            }
            if (jsonObject[key] != null && !jsonObject[key].isJsonNull){
                jsonObject[key].asJsonArray
            } else null
        } catch (e:Exception){
            e.printStackTrace()
            null
        }
    }

    fun getJsonObjectInt(jsonObject: JsonObject, key: String?): Int {
        if (jsonObject[key] != null) {
            if (!jsonObject[key].isJsonNull) {
                if (jsonObject[key].asString.equals("false", true)) {
                    return 0
                } else if (jsonObject[key].asString.equals("true", true)) {
                    return 1
                }
                return jsonObject[key].asString.toInt()
            }
        }
        return 0
    }

}