package com.recycle.task.models.categories

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.recycle.task.utills.Config

class CategoriesResponseModel {

    var Status:Int = 0
    var Message:String = ""

    var categoriesResultResponseModel: CategoriesResultResponseModel? = null

    fun getCategoriesResponse(jsonElement: JsonElement?) : CategoriesResponseModel?{
        if(jsonElement is JsonObject){
            val jsonObject = jsonElement.getAsJsonObject()
            val categoriesResponseModel = CategoriesResponseModel()
            categoriesResponseModel.decodeJson(jsonObject)
            return categoriesResponseModel
        }
        return null
    }

    private fun decodeJson(jsonObject: JsonObject?) {
        Status = Config.getJsonObjectInt(jsonObject!!, "Status")
        Message = Config.getJsonObjectString(jsonObject!!, "Message")

        val getCategoriesResult:JsonObject? = Config.getjsonObject(jsonObject, "Result")

        if (getCategoriesResult!= null){
            categoriesResultResponseModel = CategoriesResultResponseModel().getResult(getCategoriesResult)
        }
    }
}