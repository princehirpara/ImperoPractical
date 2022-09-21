package com.recycle.task.models.categories

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.recycle.task.utills.Config

class CategoriesResultResponseModel {

    var categoriesCategoryArrayList:ArrayList<CategoriesCategoryModel> = ArrayList()

    fun getResult(jsonElement: JsonElement?) : CategoriesResultResponseModel?{
        if(jsonElement is JsonObject){
            val jsonObject = jsonElement.getAsJsonObject()
            val categoriesResultResponseModel = CategoriesResultResponseModel()
            categoriesResultResponseModel.decodeJson(jsonObject)
            return categoriesResultResponseModel
        }
        return null
    }

    private fun decodeJson(jsonObject: JsonObject?) {
        val getcategory = Config.getJsonArray(jsonObject,"Category")

        categoriesCategoryArrayList = ArrayList()

        if (getcategory != null){
            categoriesCategoryArrayList = CategoriesCategoryModel().getCategories(getcategory)
        }
    }

}