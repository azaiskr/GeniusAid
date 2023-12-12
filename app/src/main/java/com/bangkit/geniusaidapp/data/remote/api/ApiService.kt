package com.bangkit.geniusaidapp.data.remote.api

import com.bangkit.geniusaidapp.data.remote.response.Payload
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    suspend fun loginUser(
        @Field("nik") nik: String,
        @Field("mother_name") mother_name: String,
        @Field("birth_date") birth_date: String
    ): Payload

}