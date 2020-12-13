package com.sifat.myapplication.Model

import com.google.gson.annotations.SerializedName


data class BrandDetailsDataModel(

    @SerializedName("BrandId")
    val brandId: Int? = null,
    @SerializedName("BrandName")
    val brandName: String? = null,
    @SerializedName("BrandNameEng")
    val brandNameEng: String? = null
)
