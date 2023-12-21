package com.bangkit.geniusaidapp.data.remote.api
import com.bangkit.geniusaidapp.data.remote.response.BansosResponse
import com.bangkit.geniusaidapp.data.remote.response.LoginUserResponse
import com.bangkit.geniusaidapp.data.remote.response.PostSubmissionResponse
import com.bangkit.geniusaidapp.data.remote.response.PutResult
import com.bangkit.geniusaidapp.data.remote.response.PutUserProfileRequest
import com.bangkit.geniusaidapp.data.remote.response.PutUserProfileResponse
import com.bangkit.geniusaidapp.data.remote.response.QuestionResponse
import com.bangkit.geniusaidapp.data.remote.response.ResultBansosItem
import com.bangkit.geniusaidapp.data.remote.response.StatusBansosResponse
import com.bangkit.geniusaidapp.data.remote.response.UserProfileResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
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
    ): BansosResponse

    @GET("submission/latest_status")
    suspend fun getStatusName(
    ): StatusBansosResponse

    @GET("questioner") // Replace with your actual endpoint
    suspend fun getQuestions(
    ): QuestionResponse

    @GET("bansos/{providerId}")
    suspend fun getBansosById(@Path("providerId") providerId: Int): ResultBansosItem



    @GET("bansos")
    suspend fun getBansos(): BansosResponse

    @POST("submission")
    suspend fun postSubmission(
        @Query("bansos_id") bansosId: Int
    ): PostSubmissionResponse

    @GET("questioner")
    suspend fun getQuestioner(): QuestionResponse



    @PUT("user/profile")
    suspend fun updateUserProfile(
        @Body userProfile: PutResult
    ): Response<PutUserProfileResponse>

    @PUT("user/profile")
    @Headers("Content-Type: application/json")
    suspend fun updateProfile(@Body request: PutUserProfileRequest): PutUserProfileResponse



}
