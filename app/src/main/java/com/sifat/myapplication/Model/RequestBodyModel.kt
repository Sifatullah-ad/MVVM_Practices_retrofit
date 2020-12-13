package com.sifat.myapplication.Model

import com.google.gson.annotations.SerializedName

data class RequestBodyModel (
    @SerializedName("SearchString")
    val SearchString: String? = null,
    @SerializedName("FromRow")
    val FromRow:Int? = null,
    @SerializedName("ToRow")
    val ToRow: Int? = null
        )