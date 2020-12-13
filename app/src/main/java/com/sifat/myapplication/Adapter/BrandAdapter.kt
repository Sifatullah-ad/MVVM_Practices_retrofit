package com.sifat.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sifat.myapplication.Model.BrandDetailsDataModel
import com.sifat.myapplication.R

class BrandAdapter(): RecyclerView.Adapter<BrandAdapter.BrandViewHolder>() {

    private val dataList: MutableList<BrandDetailsDataModel> = mutableListOf()

        class BrandViewHolder(view: View): RecyclerView.ViewHolder(view){
                val brandImage: ImageView = view.findViewById(R.id.brandImage)
                val brandTitle: TextView = view.findViewById(R.id.brandsTitle)
                val brandId: TextView = view.findViewById(R.id.brandsId)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.brandlists_layout, parent, false)
        return BrandViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        ImageBindingAdapter.loadImage(holder.brandImage, dataList[position].brandId!!)
        holder.brandId.text = dataList[position].brandName
        holder.brandTitle.text = dataList[position].brandNameEng
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    fun initLoad(list: MutableList<BrandDetailsDataModel>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }
}