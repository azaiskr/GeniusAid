package com.bangkit.geniusaidapp.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.geniusaidapp.data.remote.response.UserProfileResponse
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import com.bangkit.geniusaidapp.model.ProfileBansosList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: GeniusRepository) : ViewModel() {

    ///////////////////////////////////////////////////////

    ////Memunculkan Nama User
    private val _userProfile = mutableStateOf<UserProfileResponse?>(null)
    val userProfile: State<UserProfileResponse?> = _userProfile

    fun getUserProfile() {
        viewModelScope.launch {
            _userProfile.value = repository.getUserProfile()
        }
    }


    //////////////////////////////////////////////////////

    ////Memuntulkan ListBansos
    private val _groupedBansos = MutableStateFlow<Map<Char, List<ProfileBansosList>>>(emptyMap())
    val groupedBansos: MutableStateFlow<Map<Char, List<ProfileBansosList>>> get() = _groupedBansos
    private fun loadGroupedBansos() {
        viewModelScope.launch {
            try {
                val allBansos = repository.getAllProfBansos() // Memanggil di dalam coroutine
                val groupedBansos = allBansos
                    .sortedBy { it.bansosProviderId}
                    .groupBy { it.name[0] }
                _groupedBansos.value = groupedBansos
            } catch (e: Exception) {
                // Handle error, if any
                e.printStackTrace()
            }
        }
    }
    init {
        loadGroupedBansos()
    }
}