package com.recycle.task.models.subCategories

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.recycle.task.models.categories.CategoriesResponseModel
import com.recycle.task.models.categories.CategoriesResultResponseModel
import com.recycle.task.utills.Config


class SubcategoriesResponseModel {

    var Status :Int = 0
    var Message :String = ""

//    var subCategoriesResultResponseModel: SubCategoriesResultResponseModel? = null

    fun getSubCAtegories(jsonElement: JsonElement?) : SubcategoriesResponseModel?{
        if(jsonElement is JsonObject){
            val jsonObject = jsonElement.getAsJsonObject()
            val subCategoriesResponseModel = SubcategoriesResponseModel()
            subCategoriesResponseModel.decodeJson(jsonObject)
            return subCategoriesResponseModel
        }
        return null
    }

    private fun decodeJson(jsonObject: JsonObject?) {
        Status = Config.getJsonObjectInt(jsonObject!!, "Status")
        Message = Config.getJsonObjectString(jsonObject!!, "Message")

        val getSubCategoriesResult:JsonObject? = Config.getjsonObject(jsonObject, "Result")

        if (getSubCategoriesResult!= null){
//            subCategoriesResultResponseModelnseModel = SubCategoriesResultResponseModel().getSubCategoriesResult(getSubCategoriesResult)
        }
    }
    }

