package com.bangkit.geniusaidapp.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import com.bangkit.geniusaidapp.model.ProfileBansos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.bangkit.geniusaidapp.ui.screen.Result
import kotlinx.coroutines.flow.catch

class HomeViewModel(private val repository: GeniusRepository) : ViewModel() {

    private val _result: MutableStateFlow<Result<List<ProfileBansos>>> =
        MutableStateFlow(Result.Loading)
    val result: StateFlow<Result<List<ProfileBansos>>>
        get() = _result

    fun getAllProfilBansos() {
        viewModelScope.launch {
            repository.getAllProfilBansos()
                .catch {
                    _result.value = Result.Error(it.message.toString())
                }
                .collect { crew ->
                    _result.value = Result.Success(crew)
                }
        }
    }

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

}