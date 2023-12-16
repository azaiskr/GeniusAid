package com.bangkit.geniusaidapp.ui.screen.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.geniusaidapp.data.preference.UserModel
import com.bangkit.geniusaidapp.data.remote.response.LoginUserResponse
import com.bangkit.geniusaidapp.data.remote.response.Payload
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import com.bangkit.geniusaidapp.model.ProfileBansos
import com.bangkit.geniusaidapp.ui.screen.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class LoginUserViewModel(private val repository: GeniusRepository) : ViewModel() {

//    var loginResult : MutableLiveData<LoginUserResponse> = repository.loginUserResult
//    var isLoading: LiveData<Boolean> = repository.isLoading

    private val _result: MutableStateFlow<Result<List<Payload>>> =
        MutableStateFlow(Result.Loading)
    val result: StateFlow<Result<List<Payload>>>
        get() = _result



    fun getLogin() {
        viewModelScope.launch {
            repository.getLogin()
                .catch {
                    _result.value = Result.Error(it.message.toString())
                }
                .collect { login ->
                    _result.value = Result.Success(login)
                }
        }
    }

//    suspend fun saveSession(user: UserModel) {
//        repository.saveUser(user)
//    }

    fun isValidCredentials(nik: String, mother_name: String, birth_date : String): Boolean {
        return nik.isNotEmpty() && mother_name.isNotEmpty() && birth_date.isNotEmpty()
    }

    fun login(nik: String, mother_name: String, birth_datl : String)  {
        return repository.login(nik, mother_name, birth_datl)
    }

}