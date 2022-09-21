package com.recycle.task.models.products

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.recycle.task.models.categories.CategoriesCategoryModel
import com.recycle.task.models.categories.CategoriesResponseModel
import com.recycle.task.models.categories.CategoriesResultResponseModel
import com.recycle.task.utills.Config

class ProductsResponseModel {


    var Status:Int = 0
    var Message:String = ""

    var productModel: ArrayList<ProductResultResponseModel> = ArrayList()

    fun getResult(jsonElement: JsonElement?) : ProductsResponseModel?{
        if(jsonElement is JsonObject){
            val jsonObject = jsonElement.getAsJsonObject()
            val ProductsResponseModel = ProductsResponseModel()
            ProductsResponseModel.decodeJson(jsonObject)
            return ProductsResponseModel
        }
        return null
    }

    private fun decodeJson(jsonObject: JsonObject?) {
        Status = Config.getJsonObjectInt(jsonObject!!, "Status")
        Message = Config.getJsonObjectString(jsonObject!!, "Message")

        val getresult: JsonArray? = Config.getJsonArray(jsonObject, "Result")

        if (getresult!= null){
            productModel = ProductResultResponseModel().getProductResult(getresult)
        }
    }
}