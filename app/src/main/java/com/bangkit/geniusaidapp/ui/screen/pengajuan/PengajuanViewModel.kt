package com.bangkit.geniusaidapp.ui.screen.pengajuan

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.geniusaidapp.data.remote.response.ResultBansosItem
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import com.bangkit.geniusaidapp.model.ProfileBansosList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PengajuanViewModel(private val repository: GeniusRepository) : ViewModel() {

    //// halaman pengajuan


    // LiveData to observe the result
    private val _bansosData = mutableStateOf<List<ResultBansosItem?>?>(null)
    val bansosData: State<List<ResultBansosItem?>?> = _bansosData

    // Call this function to fetch Bansos data
    fun fetchData() {
        viewModelScope.launch {
            _bansosData.value = repository.getBansosData()
        }
    }

    //// Btn pengajuan
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