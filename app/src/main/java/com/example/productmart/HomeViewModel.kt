package com.example.productmart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    private var homeRepository:HomeRepository?=null
    var productListLiveData:LiveData<List<Product>>?=null
    init {
        homeRepository= HomeRepository()
        productListLiveData=MutableLiveData()
    }
    fun fetchAllProduct(){
        productListLiveData=homeRepository?.fetchAllProducts()
    }
}