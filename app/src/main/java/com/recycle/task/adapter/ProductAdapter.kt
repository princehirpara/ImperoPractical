package com.recycle.task.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.loopj.android.image.SmartImageView
import com.recycle.task.R
import com.recycle.task.activities.MainActivity
import com.recycle.task.models.products.ProductResultResponseModel

class ProductAdapter(
    val mainActivity: MainActivity,
    val productModel: ArrayList<ProductResultResponseModel>
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val productName:TextView = itemView.findViewById(R.id.productName)
        val productImg:SmartImageView = itemView.findViewById(R.id.productImg)
        val priceCode:TextView = itemView.findViewById(R.id.priceCode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_products, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productName.setText(productModel[position].Name)
        holder.productImg.setImageUrl(productModel[position].ImageName)
        holder.priceCode.setText(productModel[position].PriceCode)
    }

    override fun getItemCount(): Int {
        return productModel.size
    }
}