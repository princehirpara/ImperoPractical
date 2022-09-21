package com.recycle.task.models.products

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.recycle.task.models.categories.CategoriesSubCategoriesModel
import com.recycle.task.utills.Config

class ProductResultResponseModel {

    var Name:String = ""
    var PriceCode:String = ""
    var ImageName:String = ""
    var Id:Int = 0

    open fun getProductResult(jsonArray: JsonArray?) : ArrayList<ProductResultResponseModel>{
        val categoriesSubCatyegoryArrayList : ArrayList<ProductResultResponseModel> = ArrayList()
        for (i in 0 until jsonArray!!.size()) run{
            var ProductResultResponseModel = ProductResultResponseModel()

            ProductResultResponseModel.decodeJson(jsonArray.get(i).asJsonObject)
            categoriesSubCatyegoryArrayList.add(ProductResultResponseModel)
        }
        return categoriesSubCatyegoryArrayList
    }

    private fun decodeJson(jsonObject: JsonObject?) {
        Name = Config.getJsonObjectString(jsonObject!!, "Name")
        PriceCode = Config.getJsonObjectString(jsonObject!!, "PriceCode")
        ImageName = Config.getJsonObjectString(jsonObject!!, "ImageName")
        Id = Config.getJsonObjectInt(jsonObject!!, "Id")
    }


}