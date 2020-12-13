package com.sifat.myapplication.Retrofit

import com.sifat.myapplication.Model.BrandListDataModel
import com.sifat.myapplication.Model.RequestBodyModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("AppApi/Brand/LoadBrandBySearchString")
    fun getAllBrands(@Body requestBodyModel: RequestBodyModel): Call<BrandListDataModel>
}