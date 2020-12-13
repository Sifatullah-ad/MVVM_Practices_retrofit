package com.sifat.myapplication.Retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.sifat.myapplication.BuildConfig
import com.sifat.myapplication.Model.BrandDetailsDataModel
import com.sifat.myapplication.Model.BrandListDataModel
import com.sifat.myapplication.Model.RequestBodyModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitServices {

    val brandResponse: MutableLiveData<MutableList<BrandDetailsDataModel>> = MutableLiveData()

    companion object BrandGenerator{
        private const val BASE_URL = "https://api.ajkerdeal.com/"
        lateinit var retrofit: Retrofit
        private val gson by lazy {
            GsonBuilder().setLenient().setPrettyPrinting().create()
        }

        private val httpClient by lazy {
            OkHttpClient.Builder().apply {
                if (BuildConfig.DEBUG) {
                    val httpLoggingInterceptor = HttpLoggingInterceptor()
                    val logging =
                        httpLoggingInterceptor.apply {
                            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                        }
                    addInterceptor(logging)
                }
            }.build()
        }

        fun Create(): ApiInterface{
           Log.e("retrofit","Created")

            retrofit = Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create(gson))
               .client(httpClient)
               .build()
            return  retrofit.create(ApiInterface::class.java)
       }



    }

    fun loadAllBrandLists(): MutableLiveData<MutableList<BrandDetailsDataModel>>{
        val retrofitCall = Create().getAllBrands(RequestBodyModel("",0,20))
        retrofitCall.enqueue(object : retrofit2.Callback<BrandListDataModel>{
            override fun onResponse(
                call: Call<BrandListDataModel>,
                response: Response<BrandListDataModel>
            ) {

                if (response.body() != null) {

                    Log.d("debug", response.body()!!.brandData.toString())

                    brandResponse.value = response.body()!!.brandData as MutableList<BrandDetailsDataModel>
                }


            }

            override fun onFailure(call: Call<BrandListDataModel>, t: Throwable) {
               Log.e("on Fail","ERROr")
            }

        })
        return brandResponse
    }

}