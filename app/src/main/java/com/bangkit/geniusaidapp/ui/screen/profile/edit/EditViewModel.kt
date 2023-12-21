package com.bangkit.geniusaidapp.ui.screen.profile.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.geniusaidapp.data.remote.response.PutUserProfileRequest
import com.bangkit.geniusaidapp.data.remote.response.PutUserProfileResponse
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import com.bangkit.geniusaidapp.ui.screen.Result
import kotlinx.coroutines.launch

class EditViewModel(private val repository: GeniusRepository) : ViewModel() {

    private val _updateResult = MutableLiveData<Result<PutUserProfileResponse>>()
    val updateResult: LiveData<Result<PutUserProfileResponse>> get() = _updateResult

    fun updateEmail(email: String) {
        viewModelScope.launch {
            try {
                val userProfile = repository.getUserProfile()
                val updatedResult = userProfile.result?.copy(
                    email = email,
                )
                val updatedProfile = PutUserProfileRequest(
                    email = email
                )
                val result = repository.updateProfile(updatedProfile)
                _updateResult.value = Result.Success(result)
            } catch (e: Exception) {
                _updateResult.value = Result.Error(e.message ?: "An error occurred")
            }
        }
    }

    fun updatePhoneNumber(phoneNumber: String) {
        viewModelScope.launch {
            try {
                val userProfile = repository.getUserProfile()
                val updatedResult = userProfile.result?.copy(
                    phoneNumber = phoneNumber
                )
                val updatedProfile = PutUserProfileRequest(
                    phoneNumber = phoneNumber
                )
                val result = repository.updateProfile(updatedProfile)
                _updateResult.value = Result.Success(result)
            } catch (e: Exception) {
                _updateResult.value = Result.Error(e.message ?: "An error occurred")
            }
        }
    }
}