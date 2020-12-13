package com.sifat.myapplication.Model

import com.google.gson.annotations.SerializedName


data class BrandListDataModel(

    @SerializedName("MessageText")
    val brandResponseMsg: String? = "",
    @SerializedName("Data")
    val brandData: List<BrandDetailsDataModel> = listOf()
)
