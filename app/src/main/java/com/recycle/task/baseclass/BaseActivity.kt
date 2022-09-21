package com.recycle.task.baseclass

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.JsonElement
import com.recycle.task.R
import com.recycle.task.interfaces.ApiInterface
import com.recycle.task.interfaces.ResponseInterface
import com.recycle.task.models.categories.CategoriesRequestModel
import com.recycle.task.models.products.ProductRequestModel
import com.recycle.task.models.subCategories.SubCategoriesModel
import com.recycle.task.utills.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseActivity :AppCompatActivity(){

    lateinit var refreshDialog:Dialog


    open fun categoriesApiCall(context: Context, categoriesRequestModel: CategoriesRequestModel, tag:String){
        if (!(context as Activity).isFinishing){
            val apiService:ApiInterface = ApiClient.client.create(
                ApiInterface::class.java
            )

            val call :Call<JsonElement> = apiService.categories("DashBoard", "application/json", categoriesRequestModel)
            serviceCall(context, call, tag)
        }
    }


    open fun subCategoriesApiCall(context: Context, subCategoriesRequestModel: SubCategoriesModel, tag:String){
        if (!(context as Activity).isFinishing){
            val apiService:ApiInterface = ApiClient.client.create(
                ApiInterface::class.java
            )

            val call :Call<JsonElement> = apiService.subCategories("DashBoard", "application/json", subCategoriesRequestModel)
            serviceCall(context, call, tag)
        }
    }


    open fun productApiCall(context: Context, productRequestModel: ProductRequestModel, tag:String){
        if (!(context as Activity).isFinishing){
            val apiService:ApiInterface = ApiClient.client.create(
                ApiInterface::class.java
            )

            val call :Call<JsonElement> = apiService.products("ProductList", "application/json", productRequestModel)
            serviceCall(context, call, tag)
        }
    }

    private fun serviceCall(context: Activity, call: Call<JsonElement>, tag: String) {

        if (!isConnectedToInternet(context)){
            if (!(context as Activity).isDestroyed){
                Handler(Looper.getMainLooper()).postDelayed({
                    showDialogeToRefreshInternet()
                }, 3000)
                return
            } else {

            }
        }

        call.enqueue(object : Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                if (response.isSuccessful){
                    val successInterface:ResponseInterface =
                        context as ResponseInterface

                    successInterface.onSuccess(response.body()!!, tag)
                }
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {

            }

        })

    }

    private fun showDialogeToRefreshInternet() {
        refreshDialog = Dialog(this, android.R.style.Theme_Light_NoTitleBar_Fullscreen)
        refreshDialog.setCancelable(false)
        refreshDialog.setContentView(R.layout.no_internet_connection_screen)

        val refreshButton = refreshDialog.findViewById<Button>(R.id.refreshButton)

        refreshButton.setOnClickListener {
            refreshDialog.dismiss()
            if (!isConnectedToInternet(this)){
                if (!(this@BaseActivity as Activity).isDestroyed){
                    Handler(Looper.getMainLooper()).postDelayed({
                        showDialogeToRefreshInternet()
                    }, 3000)
                    return@setOnClickListener
                }
            } else {
                finish()
                overridePendingTransition(0,0)
                startActivity(getIntent())
                overridePendingTransition(0,0)
            }
        }
        refreshDialog.show()
    }

    private fun isConnectedToInternet(context:Activity):Boolean{
        val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as  ConnectivityManager


        val info = connectivity.allNetworkInfo
        for (anInfo in info) if (anInfo.state == NetworkInfo.State.CONNECTED) {
            return true
        }
        return false
    }


}