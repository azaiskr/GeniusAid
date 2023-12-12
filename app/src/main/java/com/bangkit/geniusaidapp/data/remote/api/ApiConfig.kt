package com.bangkit.geniusaidapp.data.remote.api


import com.bangkit.geniusaidapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    fun getApiService(): ApiService{
//        val loggingInterceptor = if(BuildConfig.DEBUG){
//            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//        }else{
//            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
//        }

        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

//        val authInterceptor = Interceptor { user ->
//            val requestUser = user.request()
//            val requestHeaders = requestUser.newBuilder()
//                .addHeader("Authorization", "Bearer $token")
//                .build()
//            user.proceed(requestHeaders)
//        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://capstone-404814.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }

}