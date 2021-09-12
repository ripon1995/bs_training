package com.example.basicmvvmwithdiwithnongenericviewmodelfactory.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClientHotelData {
    companion object {
        private const val Base_Url = "https://order-pizza-api.herokuapp.com/api/"
        private const val Type_Code_Base_Url = "https://jsonplaceholder.typicode.com/"
        private var retrofit: Retrofit? = null
        private val gson: Gson = GsonBuilder().setLenient().create()

        fun getClient(): Retrofit? {
            if (retrofit == null) {
                synchronized(RetrofitApiClientHotelData::class.java)
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