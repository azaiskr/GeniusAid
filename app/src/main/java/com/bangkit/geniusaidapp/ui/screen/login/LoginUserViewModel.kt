package com.bangkit.geniusaidapp.ui.screen.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangkit.geniusaidapp.data.preference.UserModel
import com.bangkit.geniusaidapp.data.remote.response.LoginUserResponse
import com.bangkit.geniusaidapp.data.repository.GeniusRepository

class LoginUserViewModel(private val repository: GeniusRepository) : ViewModel() {

    var loginResult : MutableLiveData<LoginUserResponse> = repository.loginUserResult
    var isLoading: LiveData<Boolean> = repository.isLoading

//    fun login(nik: String, mother_name: String, birth_datl : String) {
//        return repository.login(nik, mother_name, birth_datl)
//    }

    suspend fun saveSession(user: UserModel) {
        repository.saveUser(user)
    }

}