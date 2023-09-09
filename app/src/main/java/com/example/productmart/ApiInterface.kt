package com.example.productmart

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun fetchAllProducts(): Call<List<Product>>
}