package com.recycle.task.models.categories

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.recycle.task.utills.Config

class CategoriesSubCategoriesModel {

    var Id:Int = 0
    var Name:String = ""

    var categoriesProductArrayList:ArrayList<CategoriesProductModel> = ArrayList()

    open fun getSubCategories(jsonArray: JsonArray?) : ArrayList<CategoriesSubCategoriesModel>{
        val categoriesSubCatyegoryArrayList : ArrayList<CategoriesSubCategoriesModel> = ArrayList()
        for (i in 0 until jsonArray!!.size()) run{
            var categoriesSubCategoriesModel = CategoriesSubCategoriesModel()
            categoriesSubCategoriesModel.decodeJson(jsonArray.get(i).asJsonObject)
            categoriesSubCatyegoryArrayList.add(categoriesSubCategoriesModel)
        }
        return categoriesSubCatyegoryArrayList
    }

    private fun decodeJson(jsonObject: JsonObject?) {
        Id = Config.getJsonObjectInt(jsonObject!!, "Id")
        Name = Config.getJsonObjectString(jsonObject!!, "Name")

        val getProducts = Config.getJsonArray(jsonObject,"Product")

        categoriesProductArrayList = ArrayList()

        if (getProducts != null){
            categoriesProductArrayList = CategoriesProductModel().getProducts(getProducts)
        }
    }
}