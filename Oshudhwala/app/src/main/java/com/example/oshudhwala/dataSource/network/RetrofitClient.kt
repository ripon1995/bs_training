package com.example.oshudhwala.dataSource.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.logging.Logger.getLogger

class RetrofitClient {

    companion object {
        private const val Base_Url = "https://oshudhwala-a376a-default-rtdb.firebaseio.com/"
        private var retrofit: Retrofit? = null
        private val gson: Gson = GsonBuilder().setLenient().create()

        fun getId(): Retrofit? {
            if (retrofit == null) {
                synchronized(RetrofitClient::class.java)
                {
                    if (retrofit == null) {
                        retrofit = Retrofit.Builder()
                            .baseUrl(Base_Url).client(getLogger())
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
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