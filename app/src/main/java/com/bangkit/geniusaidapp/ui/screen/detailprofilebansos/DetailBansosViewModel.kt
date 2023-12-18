package com.bangkit.geniusaidapp.ui.screen.detailprofilebansos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import com.bangkit.geniusaidapp.model.ProfileBansos
import com.bangkit.geniusaidapp.ui.screen.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailBansosViewModel(
    private val repository: GeniusRepository
) : ViewModel() {

    private val _result: MutableStateFlow<Result<ProfileBansos>> =
        MutableStateFlow(Result.Loading)
    val result: StateFlow<Result<ProfileBansos>>
        get() = _result

    suspend fun getBansosById(bansosName: String): List<ProfileBansos> {
        return repository.getPrfileBansosName(bansosName)
    }
}