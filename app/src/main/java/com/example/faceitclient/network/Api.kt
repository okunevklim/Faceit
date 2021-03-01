package com.example.faceitclient.network

import com.example.faceitclient.BuildConfig
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private lateinit var serviceFaceit: FaceitService
    var gson = Gson()

    private fun init() {
        val logging = HttpLoggingInterceptor()
        logging.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(URL.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
        serviceFaceit = retrofit.create(FaceitService::class.java)
    }

    fun getService(): FaceitService {
        if (!this::serviceFaceit.isInitialized) {
            init()
        }
        return serviceFaceit
    }

    object URL {
        const val SERVER_URL = ""
    }
}