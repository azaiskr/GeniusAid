package com.bangkit.geniusaidapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.tracing.perfetto.handshake.protocol.Response
import com.bangkit.geniusaidapp.data.preference.UserModel
import com.bangkit.geniusaidapp.data.preference.UserPreferences
import com.bangkit.geniusaidapp.data.remote.api.ApiService
import com.bangkit.geniusaidapp.data.remote.response.LoginUserResponse
import com.bangkit.geniusaidapp.data.remote.response.Result
import com.bangkit.geniusaidapp.model.ListProfilBansos
import com.bangkit.geniusaidapp.model.ProfileBansos
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.chromium.base.Callback
import org.chromium.base.Log
import retrofit2.Call

class GeniusRepository (
    private val apiService: ApiService,
    private val userPreferences: UserPreferences
){

    private val listCrew = mutableListOf<ProfileBansos>()

    private var _listUser = MutableLiveData<List<Result>>()
    var listUser: MutableLiveData<List<Result>> = _listUser


    private var _loginUserResult = MutableLiveData<LoginUserResponse>()
    var loginUserResult: MutableLiveData<LoginUserResponse> = _loginUserResult


    var _isLoading = MutableLiveData<Boolean>()
    var isLoading: LiveData<Boolean> = _isLoading


//    fun login(nik: String, mother_name: String, birth_date : String) {
//        _isLoading.value = true
//        val client = apiService.loginUser(nik, mother_name, birth_date)
//        client.enqueue(object : Callback<LoginUserResponse> {
//            override fun onResponse(
//                call: Call<LoginUserResponse>,
//                response: Response<LoginUserResponse>
//            ) {
//                if (response.isSuccessful) {
//                    _isLoading.value = false
//                    _loginUserResult.value = response.body()
//                }
//            }
//
//            override fun onFailure(call: Call<LoginUserResponse>, t: Throwable) {
//                Log.e("Repository", "error: ${t.message}")
//            }
//        })
//    }


    suspend fun saveUser(user: UserModel) {
        userPreferences.saveUser(user)
    }

    fun getUser(): Flow<UserModel> {
        return userPreferences.getUser()
    }

    suspend fun logout() {
        userPreferences.logOut()
    }

    init {
        ListProfilBansos.profilBansos.forEach {
            listCrew.add(
                ProfileBansos(it.id, it.nameSigkat, it.name, it.description, it.photoUrl)
            )
        }
    }

    fun getAllProfilBansos(): Flow<List<ProfileBansos>> {
        return flowOf(listCrew)
    }

    fun getProfilBansosById(crewId: Long): ProfileBansos {
        return listCrew.first {
            it.id == crewId
        }
    }

    companion object {
        @Volatile
        private var instance: GeniusRepository? = null

        fun clearInstance() {
            instance = null
        }

        fun getInstance(apiService: ApiService, pref: UserPreferences,): GeniusRepository =
            instance ?: synchronized(this) {
                instance ?: GeniusRepository(apiService, pref)
//                GeniusRepository(apiService, pref).apply {
//                    instance = this
                }.also { instance = it }
            }
    }
