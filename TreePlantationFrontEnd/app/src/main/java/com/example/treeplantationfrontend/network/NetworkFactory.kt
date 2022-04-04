package com.example.treeplantationfrontend.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkFactory {
    private const val BASE_URL = "http://192.168.68.108:8000/"
    private var retrofit: Retrofit? = null
    private val gson: Gson = GsonBuilder().setLenient().create()
    private const val TIME_OUT = 60L

    fun getClient(): Retrofit? {
        if (retrofit == null) {
            synchronized(NetworkFactory::class.java)
            {
                if (retrofit == null) {
                    val logInterceptor = getLogInterceptors()
                    retrofit =
                        Retrofit.Builder().baseUrl(BASE_URL).client(getOkHttpClient(logInterceptor))
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                            .build()
                }
            }
        }
        return retrofit
    }

    private fun getOkHttpClient(logInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(logInterceptor)

            .authenticator(object : Authenticator {
                override fun authenticate(route: Route?, response: Response): Request? {
                    if (response.code == 401 || response.code == 403) {
                        val okhttpClient =
                            OkHttpClient.Builder().addInterceptor(
                                LoggingInterceptor.Builder()
                                    .apply {
                                        this.setLevel(Level.BASIC)
                                    }
                                    .build()).build()

                    } else return response.request
                    return response.request
                }
            })
            .build()
    }

    private fun getLogInterceptors(): Interceptor {
        return LoggingInterceptor.Builder().apply {
            this.addHeader("Cache-control", "no-cache")
            this.setLevel(Level.BASIC)
        }.build()
    }
}