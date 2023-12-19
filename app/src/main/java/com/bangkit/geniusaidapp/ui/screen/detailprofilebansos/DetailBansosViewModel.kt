package com.bangkit.geniusaidapp.ui.screen.detailprofilebansos

import androidx.lifecycle.ViewModel
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import com.bangkit.geniusaidapp.model.ProfileBansosList
import com.bangkit.geniusaidapp.ui.screen.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailBansosViewModel(
    private val repository: GeniusRepository
) : ViewModel() {

    private val _result: MutableStateFlow<Result<ProfileBansosList>> =
        MutableStateFlow(Result.Loading)
    val result: StateFlow<Result<ProfileBansosList>>
        get() = _result

    suspend fun getBansosById(bansosId: Int): List<ProfileBansosList> {
        return repository.getPrfileBansosName(bansosId)
    }
}