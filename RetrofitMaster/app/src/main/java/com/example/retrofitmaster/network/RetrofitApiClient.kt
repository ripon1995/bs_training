package com.example.retrofitmaster.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient {
private constructor()
    companion object{
        val Base_Url="https://jsonplaceholder.typicode.com/"
        private var retrofit: Retrofit?=null
        private val gson :Gson= GsonBuilder().setLenient().create()

        fun getClient():Retrofit?{
            if(retrofit==null)
            {
                synchronized(RetrofitApiClient::class.java)
                {
                    if(retrofit==null)
                    {
                        retrofit = Retrofit.Builder().baseUrl(Base_Url).addConverterFactory(GsonConverterFactory.create(gson)).build()
                    }
                }
            }
            return retrofit
        }
    }
}