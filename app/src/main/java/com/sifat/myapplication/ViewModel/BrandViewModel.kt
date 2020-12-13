package com.sifat.myapplication.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sifat.myapplication.Model.BrandDetailsDataModel
import com.sifat.myapplication.Model.BrandListDataModel
import com.sifat.myapplication.Retrofit.RetrofitServices

class BrandViewModel: ViewModel() {
     private val retroService = RetrofitServices()
             fun getAllBrandsData(): MutableLiveData<MutableList<BrandDetailsDataModel>>{
                 Log.e("Get ALL Brand List","YES")
                 return retroService.loadAllBrandLists()
             }
}