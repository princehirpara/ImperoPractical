package com.recycle.task.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.recycle.task.R
import com.recycle.task.activities.MainActivity
import com.recycle.task.models.categories.CategoriesSubCategoriesModel
import com.recycle.task.models.products.ProductResultResponseModel

class SubCategoriesAdapter(
    val mainActivity: MainActivity,
    val categoriesCategoryArrayList: ArrayList<CategoriesSubCategoriesModel>,
    val productModel: ArrayList<ProductResultResponseModel>
) :RecyclerView.Adapter<SubCategoriesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val subcategoryName : TextView = itemView.findViewById(R.id.subcategoryName)
        val productsRecyclerView:RecyclerView = itemView.findViewById(R.id.productsRecyclerView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_sub_categories, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.subcategoryName.setText(categoriesCategoryArrayList[position].Name)

        val layoutManager = LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false)
        holder.productsRecyclerView.layoutManager = layoutManager

        holder.productsRecyclerView.adapter = ProductAdapter(mainActivity,productModel )

    }

    override fun getItemCount(): Int {
        return categoriesCategoryArrayList.size
    }
}