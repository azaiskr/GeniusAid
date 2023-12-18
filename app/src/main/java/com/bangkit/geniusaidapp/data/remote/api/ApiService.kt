package com.bangkit.geniusaidapp.data.remote.api

import com.bangkit.geniusaidapp.data.remote.response.ListBansosResponse
import com.bangkit.geniusaidapp.data.remote.response.LoginResult
import com.bangkit.geniusaidapp.data.remote.response.LoginUserResponse
import com.bangkit.geniusaidapp.data.remote.response.Payload
import com.bangkit.geniusaidapp.data.remote.response.Result
import com.bangkit.geniusaidapp.data.remote.response.StatusBansosResponse
import com.bangkit.geniusaidapp.data.remote.response.UserProfileResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("login/user")
    fun loginUser(
        @Query("nik") nik: String,
        @Query("mother_name") motherName: String,
        @Query("birth_date") birthDate: String
    ): Call<LoginUserResponse>

    @GET("user/profile")
    suspend fun getUserProfile(
    ): UserProfileResponse

    @GET("bansos")
    suspend fun getListBansos(
    ): ListBansosResponse

    @GET("submission/latest_status")
    suspend fun getStatusName(
    ): StatusBansosResponse

}