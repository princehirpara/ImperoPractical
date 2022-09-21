package com.recycle.task.activities

import android.annotation.SuppressLint
import android.os.Build.PRODUCT
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.gson.JsonElement
import com.recycle.task.R
import com.recycle.task.adapter.SubCategoriesAdapter
import com.recycle.task.baseclass.BaseActivity
import com.recycle.task.interfaces.ResponseInterface
import com.recycle.task.models.categories.CategoriesRequestModel
import com.recycle.task.models.categories.CategoriesResponseModel
import com.recycle.task.models.categories.CategoriesSubCategoriesModel
import com.recycle.task.models.products.ProductRequestModel
import com.recycle.task.models.products.ProductsResponseModel
import com.recycle.task.models.subCategories.SubCategoriesModel
import com.recycle.task.utills.Constant.Companion.CATEGORIES
import com.recycle.task.utills.Constant.Companion.SUBCATEGORIES

class MainActivity : BaseActivity(), ResponseInterface {

    lateinit var tabLayout: TabLayout
    lateinit var subCategoriesRecyuclerView: RecyclerView


    var CategoriesCategoryModel:ArrayList<CategoriesSubCategoriesModel> = ArrayList()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        subCategoriesRecyuclerView = findViewById(R.id.subCategoriesRecyuclerView)

        val categoriesRequestModel = CategoriesRequestModel(0, "Google", "Android SDK built for x86", "", 1)
        categoriesApiCall(this@MainActivity, categoriesRequestModel, CATEGORIES)

        val subCategoriesModel = SubCategoriesModel(56, 1)
        subCategoriesApiCall(this@MainActivity, subCategoriesModel, SUBCATEGORIES)



    }

    override fun onSuccess(jsonElement: JsonElement, tag: String) {

        if(tag.equals(CATEGORIES)){
            val categoriesResponseModel = CategoriesResponseModel().getCategoriesResponse(jsonElement)
            if (categoriesResponseModel!!.Status.equals(200)){
                for (i in 0 until categoriesResponseModel.categoriesResultResponseModel!!.categoriesCategoryArrayList.size){
                    tabLayout.addTab(tabLayout.newTab().setText(categoriesResponseModel.categoriesResultResponseModel!!.categoriesCategoryArrayList[i].Name))
                }
            } else {
            }
        }

        if(tag.equals(SUBCATEGORIES)){
            val categoriesResponseModel = CategoriesResponseModel().getCategoriesResponse(jsonElement)

            if (categoriesResponseModel!!.Status.equals(200)){

                CategoriesCategoryModel = categoriesResponseModel.categoriesResultResponseModel!!.categoriesCategoryArrayList[0].subCategoriesArrayList

                val productRequestModel = ProductRequestModel(2, 71)
                productApiCall(this@MainActivity, productRequestModel, PRODUCT)
            }


        }

        if(tag.equals(PRODUCT)){
            val ProductsResponseModel = ProductsResponseModel().getResult(jsonElement)

            if (ProductsResponseModel!!.Status.equals(200)){
                val layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                subCategoriesRecyuclerView.layoutManager = layoutManager

                subCategoriesRecyuclerView.adapter = SubCategoriesAdapter(this@MainActivity, CategoriesCategoryModel, ProductsResponseModel.productModel)
            }


        }


    }
}