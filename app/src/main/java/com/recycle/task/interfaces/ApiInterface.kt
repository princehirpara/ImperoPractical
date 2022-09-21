package com.recycle.task.interfaces

import com.google.gson.JsonElement
import com.recycle.task.models.categories.CategoriesRequestModel
import com.recycle.task.models.products.ProductRequestModel
import com.recycle.task.models.products.ProductsResponseModel
import com.recycle.task.models.subCategories.SubCategoriesModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiInterface {

    @POST
    fun categories(
        @Url url: String,
        @Header("Content-Type") header: String?,
        @Body categoriesRequestModel: CategoriesRequestModel
    ): Call<JsonElement>

    @POST
    fun subCategories(
        @Url url: String,
        @Header("Content-Type") header: String?,
        @Body categoriesRequestModel: SubCategoriesModel
    ): Call<JsonElement>

    @POST
    fun products(
        @Url url: String,
        @Header("Content-Type") header: String?,
        @Body productRequest: ProductRequestModel
    ): Call<JsonElement>
}