package com.bangkit.geniusaidapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bangkit.geniusaidapp.data.preference.UserPreferences
import com.bangkit.geniusaidapp.data.remote.api.ApiService
import com.bangkit.geniusaidapp.data.remote.response.ListBansosResponse
import com.bangkit.geniusaidapp.data.remote.response.LoginResult
import com.bangkit.geniusaidapp.data.remote.response.LoginUserResponse
import com.bangkit.geniusaidapp.data.remote.response.Payload
import com.bangkit.geniusaidapp.data.remote.response.Result
import com.bangkit.geniusaidapp.data.remote.response.ResultItemBansos
import com.bangkit.geniusaidapp.data.remote.response.StatusBansosResponse
import com.bangkit.geniusaidapp.data.remote.response.StatusListItem
import com.bangkit.geniusaidapp.data.remote.response.UserProfileResponse
import com.bangkit.geniusaidapp.model.ProfileBansos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import retrofit2.Call

class GeniusRepository (
    private val apiService: ApiService,
    private val userPreferences: UserPreferences
){

    /////Untuk Login
    suspend fun login(nik: String, motherName: String, birthDate: String): LoginUserResponse? {
        return withContext(Dispatchers.IO) { // Jalankan di thread terpisah
            try {
                val response = apiService.loginUser(nik, motherName, birthDate).execute()
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            } catch (e: Exception) {
                Log.e("Repository", "Login error: ${e.message}")
                null
            }
        }
    }

    ///////Untuk Get Data User
    suspend fun getUserProfile(): UserProfileResponse {
        return apiService.getUserProfile()
    }


    ////Untuk Get name dan umur di statusBansos
    suspend fun getStatusName(): StatusBansosResponse {
        return apiService.getStatusName()
    }


    /////Untuk Get Status BANSOSsnya
    suspend fun getStatusBansos(): List<StatusListItem> {
        val statusListResponse = apiService.getStatusName().result?.statusList
        return statusListResponse?.filterNotNull() ?: emptyList()
    }



    ///////SaveUser
    suspend fun saveUser(user: LoginResult) {
        userPreferences.saveUser(user)
    }

    /////LogOut
    suspend fun logout() {
        userPreferences.logOut()
    }


    /////Profile Bansos
    suspend fun getAllProfBansos(): List<ProfileBansos> {
        return try {
            val response = apiService.getListBansos()
            response.result?.mapNotNull { it?.toItemBansos() } ?: emptyList()
        } catch (e: Exception) {
            // Handle error sesuai kebutuhan aplikasi Anda
            emptyList()
        }
    }

    suspend fun getPrfileBansosName(bansosName: String): List<ProfileBansos> {
        return getAllProfBansos().filter { it.name == bansosName }
    }

    companion object {
        @Volatile
        private var instance: GeniusRepository? = null


        fun getInstance(apiService: ApiService, pref: UserPreferences,): GeniusRepository =
            instance ?: synchronized(this) {
                instance ?: GeniusRepository(apiService, pref)
            }.also { instance = it }
    }
}
