package com.bangkit.geniusaidapp.ui.screen.profile

import android.text.BoringLayout
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.geniusaidapp.data.remote.response.UserProfileResponse
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: GeniusRepository) : ViewModel() {

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

    private val _userProfile = mutableStateOf<UserProfileResponse?>(null)
    val userProfile: State<UserProfileResponse?> = _userProfile

    fun getUserProfile() {
        viewModelScope.launch {
            _userProfile.value = repository.getUserProfile()
        }
    }

}