package com.example.productmart

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL="https://fakestoreapi.com/"
class ApiClient{
    companion object{
        private var retrofit:Retrofit?=null
        fun getApiClient():Retrofit{
            val gson=GsonBuilder()
                .setLenient()
                .create()
            val okHttClient=OkHttpClient.Builder()
                .readTimeout(100,TimeUnit.SECONDS)
                .connectTimeout(100,TimeUnit.SECONDS)
                .build()
            if (retrofit==null){
                retrofit=Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit!!
        }
    }
}