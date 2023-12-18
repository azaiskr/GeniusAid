package com.bangkit.geniusaidapp.ui.screen.hasilstatusbansos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.geniusaidapp.data.remote.response.StatusBansosResponse
import com.bangkit.geniusaidapp.data.remote.response.StatusListItem
import com.bangkit.geniusaidapp.data.remote.response.UserProfileResponse
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import kotlinx.coroutines.launch

class HasilStatusBansosViewModel(private val repository: GeniusRepository) : ViewModel() {


    //////Untuk menampilkan alamat provinsi dan lain lain
    private val _userAlamat = mutableStateOf<UserProfileResponse?>(null)
    val userAlamat: State<UserProfileResponse?> = _userAlamat

    fun getUserAlamat() {
        viewModelScope.launch {
            _userAlamat.value = repository.getUserProfile()
        }
    }

    //////Untuk menampilkan nama dan umur user
    private val _userStatusName = mutableStateOf<StatusBansosResponse?>(null)
    val userStatusName: State<StatusBansosResponse?> = _userStatusName

    fun getStatusName() {
        viewModelScope.launch {
            _userStatusName.value = repository.getStatusName()
        }
    }

    ///////Untuk Menampilkan Hasil Status Bansos

    private val _statusBansos = mutableStateOf<List<StatusListItem>>(emptyList())
    val statusListBansos: State<List<StatusListItem>> get() = _statusBansos

    fun fetchStatusList() {
        viewModelScope.launch {
            try {
                _statusBansos.value = repository.getStatusBansos()
            } catch (e: Exception) {
                // Handle the exception, log it, or show an error message
                e.printStackTrace()
            }
        }
    }

}