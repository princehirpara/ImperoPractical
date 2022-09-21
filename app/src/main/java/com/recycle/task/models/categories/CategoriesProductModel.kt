package com.recycle.task.models.categories

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.recycle.task.utills.Config

class CategoriesProductModel {

    var Name:String = ""
    var PriceCode:String = ""
    var ImageName:String = ""
    var Id:Int = 0

    open fun getProducts(jsonArray: JsonArray?) : ArrayList<CategoriesProductModel>{
        val categoriesProductArrayLiost : ArrayList<CategoriesProductModel> = ArrayList()
        for (i in 0 until jsonArray!!.size()) run{
            var categoriesProductModel = CategoriesProductModel()
            categoriesProductModel.decodeJson(jsonArray.get(i).asJsonObject)
            categoriesProductArrayLiost.add(categoriesProductModel)
        }
        return categoriesProductArrayLiost
    }

    private fun decodeJson(jsonObject: JsonObject?) {

        Name = Config.getJsonObjectString(jsonObject!!, "Name")
        PriceCode = Config.getJsonObjectString(jsonObject!!, "PriceCode")
        ImageName = Config.getJsonObjectString(jsonObject!!, "ImageName")
        Id = Config.getJsonObjectInt(jsonObject!!, "Id")

    }
}