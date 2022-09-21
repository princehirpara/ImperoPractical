package com.recycle.task.models.categories

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.recycle.task.utills.Config

class CategoriesCategoryModel {

    var Id:Int = 0
    var Name:String = ""
    var IsAuthorize:Int = 0
    var Update080819:Int = 0
    var Update130919:Int = 0

    var subCategoriesArrayList:ArrayList<CategoriesSubCategoriesModel> = ArrayList()




    open fun getCategories(jsonArray: JsonArray?) : ArrayList<CategoriesCategoryModel>{
        val categoriesCatyegoryArrayList : ArrayList<CategoriesCategoryModel> = ArrayList()
        for (i in 0 until jsonArray!!.size()) run{
            var categoriesCategoryModel = CategoriesCategoryModel()
            categoriesCategoryModel.decodeJson(jsonArray.get(i).asJsonObject)
            categoriesCatyegoryArrayList.add(categoriesCategoryModel)
        }
        return categoriesCatyegoryArrayList
    }

    private fun decodeJson(jsonObject: JsonObject?) {
        Id = Config.getJsonObjectInt(jsonObject!!, "Id")
        Name = Config.getJsonObjectString(jsonObject!!, "Name")
        IsAuthorize = Config.getJsonObjectInt(jsonObject!!, "IsAuthorize")
        Update080819 = Config.getJsonObjectInt(jsonObject!!, "Update080819")
        Update130919 = Config.getJsonObjectInt(jsonObject!!, "Update130919")

        val getSubvCategories = Config.getJsonArray(jsonObject,"SubCategories")

        subCategoriesArrayList = ArrayList()

        if (getSubvCategories != null){
            subCategoriesArrayList = CategoriesSubCategoriesModel().getSubCategories(getSubvCategories)
        }
    }
}