package com.example.productmart

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Response

class HomeRepository {
    val data=MutableLiveData<List<Product>>()
    var apiInterface:ApiInterface?=ApiClient.getApiClient().create(ApiInterface::class.java)
    fun fetchAllProducts():LiveData<List<Product>>{
        apiInterface?.fetchAllProducts()?.enqueue(object : retrofit2.Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                Log.d("TAG",response.code().toString())
                var res=response.body()
                if (response.code()==200 && res!=null){
                    data.value=res
                }else{
                    data.value=null
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                data.value=null
                Log.d("TAG",t.message.toString())
            }

        })
        return data
    }
}