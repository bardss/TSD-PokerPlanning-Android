package com.tsdproject.pokerplanning.service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

object ServiceFactory {

    private var httpClient: OkHttpClient? = null
    private var noAuthHttpClient: OkHttpClient? = null

    private val gson: Gson
        get() = GsonBuilder()
                .setLenient()
                .serializeNulls()
                .create()

    public fun <T> createRetrofitService(clazz: Class<T>, endPoint: String): T {
        return createRetrofitService(clazz, endPoint, false)
    }

    public fun <T> createRetrofitService(
            clazz: Class<T>,
            endPoint: String,
            authorizationHeader: Boolean
    ): T {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = if (authorizationHeader) createHttpClient() else createNoAuthHttpClient()

        val retrofit = Retrofit.Builder()
                .baseUrl(endPoint)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        return retrofit.create(clazz)
    }

    private fun createHttpClient(): OkHttpClient {
        return httpClient ?: OkHttpClient.Builder()
                .addInterceptor(createHttpLoggingInterceptor())
                .build()
    }

    private fun createNoAuthHttpClient(): OkHttpClient {
        return noAuthHttpClient ?: OkHttpClient.Builder()
                .addInterceptor(createHttpLoggingInterceptor())
                .build()
    }

    private fun createHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor { message -> Timber.tag("OkHttp").d(message) }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

}
