package com.sifat.myapplication.Adapter


import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sifat.myapplication.R

object ImageBindingAdapter {

    fun loadImage(brandImage: ImageView, id: Int){
        Glide.with(brandImage)
            .load("https://static.ajkerdeal.com/img/brand/"+id+".png")
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .fallback(R.drawable.ic_launcher_foreground)
            .into(brandImage)
    }
}