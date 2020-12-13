package com.sifat.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sifat.myapplication.Adapter.BrandAdapter
import com.sifat.myapplication.Model.BrandListDataModel
import com.sifat.myapplication.ViewModel.BrandViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    var brandList = arrayListOf<BrandListDataModel>()

    private lateinit var dataAdapter: BrandAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this@MainActivity)
        dataAdapter = BrandAdapter()
        with(brands_recycler_view) {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            adapter = dataAdapter
        }
        getAllBrandInformation()
    }


    private fun getAllBrandInformation() {
        Log.e("getAndroidVersion", "yes")
        val brandListViewModel = ViewModelProvider(this).get(BrandViewModel::class.java)
        brandListViewModel.getAllBrandsData().observe(this, Observer { list ->
            dataAdapter.initLoad(list)
        })

    }
}