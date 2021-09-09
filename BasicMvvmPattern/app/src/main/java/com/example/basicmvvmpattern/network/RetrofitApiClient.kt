package com.example.basicmvvmpattern.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient {
    companion object {
        private const val Base_Url = "https://order-pizza-api.herokuapp.com/api/"
        private var retrofit: Retrofit? = null
        private val gson: Gson = GsonBuilder().setLenient().create()

        fun getClient(): Retrofit? {
            if (retrofit == null) {
                synchronized(RetrofitApiClient::class.java)
                {
                    if (retrofit == null) {
                        retrofit = Retrofit.Builder().baseUrl(Base_Url).client(getLogger())
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                            .build()
                    }
                }
            }
            return retrofit
        }

        fun getLogger(): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
            val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return client
        }
    }
}