package com.bangkit.geniusaidapp.ui.screen.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.geniusaidapp.data.remote.response.LoginResult
import com.bangkit.geniusaidapp.data.remote.response.LoginUserResponse
import com.bangkit.geniusaidapp.data.remote.response.Payload
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import com.bangkit.geniusaidapp.ui.screen.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginUserViewModel(private val repository: GeniusRepository) : ViewModel() {

    private var _loginUserResult = MutableLiveData<LoginUserResponse>()
    val loginUserResult: LiveData<LoginUserResponse> = _loginUserResult


    fun isValidCredentials(nik: String, mother_name: String, birth_date : String): Boolean {
        val dateRegex = Regex("\\d{4}-\\d{2}-\\d{2}")
        return nik.isNotEmpty() && mother_name.isNotEmpty() && birth_date.matches(dateRegex)
    }

    fun login(nik: String, motherName: String, birthDate: String) {
        viewModelScope.launch {
            repository.login(nik, motherName, birthDate).let { response ->
                _loginUserResult.postValue(response)

                response?.result?.let { saveUser(it) }
            }
        }
    }

    fun saveUser(user: LoginResult) {
        viewModelScope.launch {

            repository.saveUser(user)
        }

    }

}